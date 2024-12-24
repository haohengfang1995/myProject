package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.ChatDto;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.RoomDto;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.ChatService;
import com.example.demo.service.ProductService;
import com.example.demo.service.RoomService;
import com.example.demo.service.UserService;
import com.example.demo.utils.KeyUtil;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = { "/room" })
public class RoomController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	RoomService roomServie;

	@Autowired
	ChatService chatService;

	@GetMapping("/add/{productId}")
	public String addroom(Model model, HttpSession session, @PathVariable String productId) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		Integer buyId = userCert.getUserId();
		ProductDto productDto = productService.findProductByProductId(Integer.valueOf(productId));
		RoomDto roomDto = new RoomDto();
		roomDto.setBuyUserId(buyId);
		roomDto.setSaleUserId(productDto.getPorductUserId());
		roomDto.setProductId(productDto.getProductId());
		LocalDate date = LocalDate.now();
		Date sqlDate = Date.valueOf(date);
		UserDto buyUser = (UserDto) userService.findUserById(buyId);
		UserDto saleUser = userService.findUserById(productDto.getPorductUserId());
		roomDto.setRoomDate(sqlDate);
		roomDto.setProductName(productDto.getProductName());
		roomDto.setProductPlace(productDto.getProductPlace());
		roomDto.setProductPrice(String.valueOf(productDto.getProductPrice()));
		roomDto.setBuyUserName(buyUser.getUserName());
		roomDto.setSaleUserName(saleUser.getUserName());
		roomDto.setProductPhoto(productDto.getProductPhoto());
		try {
			SecretKey secretKey = KeyUtil.generateAESKey();
			byte[] byteKey = secretKey.getEncoded();
			String passKey = KeyUtil.bytesToHex(byteKey);
			System.out.println("密碼" + passKey);
			roomDto.setPassKey(passKey);
			roomServie.addRoom(roomDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product";
	}

	@GetMapping("/saleorder")
	public String saleOrder(Model model, HttpSession session) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		List<RoomDto> roomDtos = roomServie.findAllRoomSaleId(userCert.getUserId());
		model.addAttribute("roomDtos", roomDtos);
		return "roomSale";
	}

	@GetMapping("/buyorder")
	public String buyOrder(Model model, HttpSession session) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		List<RoomDto> roomDtos = roomServie.findAllRoomBuyId(userCert.getUserId());
		model.addAttribute("roomDtos", roomDtos);
		return "roomBuy";
	}

	@GetMapping("/order/{roomId}")
	public String buyroom(Model model, @PathVariable("roomId") Integer roomId, HttpSession session) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		Integer userId = userCert.getUserId();
		String userName = userCert.getUserName();
		RoomDto roomDto = roomServie.findRoomById(roomId);
		String passKey = roomDto.getPassKey();
		model.addAttribute("roomId", roomId);
		model.addAttribute("userId", userId);
		model.addAttribute("userName", userName);
		model.addAttribute("roomDto", roomDto);
		model.addAttribute("passKey", passKey);
		List<ChatDto> chatDtos = chatService.findChatByRoomId(roomId);
		if (!chatDtos.isEmpty()) {
			List<String> messages = chatDtos.stream().map(e -> e.getMessage()).collect(Collectors.toList());
			model.addAttribute("messages", messages);
		}
//		List<String> messages = chatService.findChatByRoomId(roomId).stream().map(e -> e.getMessage())
//				.collect(Collectors.toList());
//		System.out.println(messages);
//		model.addAttribute("messages", messages);
		return "ws4";
	}

	@GetMapping("/sale/{roomId}")
	public String saleroom(Model model, @PathVariable("roomId") Integer roomId, HttpSession session) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		Integer userId = userCert.getUserId();
		String userName = userCert.getUserName();
		RoomDto roomDto = roomServie.findRoomById(roomId);
		String passKey = roomDto.getPassKey();
		model.addAttribute("passKey", passKey);
		model.addAttribute("roomId", roomId);
		model.addAttribute("userId", userId);
		model.addAttribute("userName", userName);
		model.addAttribute("roomDto", roomDto);
		List<ChatDto> chatDtos = chatService.findChatByRoomId(roomId);
//		System.out.println(chatDtos);
		if (!chatDtos.isEmpty()) {
			List<String> messages = chatDtos.stream().map(e -> e.getMessage()).collect(Collectors.toList());
			model.addAttribute("messages", messages);
		}

//		List<String> messages = chatService.findChatByRoomId(roomId).stream().map(e -> e.getMessage())
//				.collect(Collectors.toList());
//		System.out.println(messages);
//		model.addAttribute("messages", messages);
		return "ws4";
	}

}
