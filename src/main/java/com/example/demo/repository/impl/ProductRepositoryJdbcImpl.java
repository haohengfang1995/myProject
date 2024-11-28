package com.example.demo.repository.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Product;
import com.example.demo.repository.ProductRepositoryJdbc;

@Repository
@PropertySource("classpath:sql.properties")
public class ProductRepositoryJdbcImpl implements ProductRepositoryJdbc{

	
	private static final Logger Logger = LoggerFactory.getLogger(ProductRepositoryJdbcImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${product.sql.findAllProductSql}")
	private String findAllProductSql;
	
	@Value("${product.sql.findNotUsProductSql}")
	private String findNotUsProductSql;
	
	@Value("${product.sql.findProductByUserIdSQl}")
	private String findProductByUserIdSQl;
	
	@Value("${product.sql.findProdcutByProductIdSql}")
	private String findProductByProductIdSql;
	
	@Value("${product.sql.findProductByHighSql}")
	private String findProductByHighSql;
	
	@Value("${product.sql.findProdcutByLowSql}")
	private String findProductByLowSql;
	
	@Value("${product.sql.findProductByPlaceSql}")
	private String findProductByPlaceSql;
	
	@Value("${product.sql.findProductByNewSql}")
	private String findProductByNewSql;
	
	@Value("${product.sql.findProductByOldSql}")
	private String findProductByOldSql;
	
	@Value("${product.sql.findProductbyIdolNameSql}")
	private String findProductbyIdolNameSql;
	
	@Value("${product.sql.findProductByGenderSql}")
	private String findProductByGenderSql;
	
	@Value("${product.sql.findProductByTypeSql}")
	private String findProductByTypeSql;
	
	@Value("${product.sql.findProductByTagSql}")
	private String findProductByTagSql;
	
	@Value("${product.sql.findProductBySerchSql}")
	private String findProductBySerchSql;
	
	@Value("${product.sql.saveProductSql}")
	private String saveProductSql;
	
	@Value("${product.sql.updateProductSql}")
	private String updateProductSql;
	
	@Value("${product.sql.deleteProductSql}")
	private String deleteProductSql;
	
	
	//找尋所有商品
	@Override
	public List<Product> findAllProduct() {
		String sql = "select * from product";
		return jdbcTemplate.query(findAllProductSql, new BeanPropertyRowMapper<>(Product.class));
	}
	
	//找尋除了自己商品列表
	@Override
	public List<Product> findNotUsProduct(Integer userId) {
		String sql = "select * from product where product_user_id != ?";
		return jdbcTemplate.query(findNotUsProductSql, new BeanPropertyRowMapper<>(Product.class), userId);
	}
	
	//找尋自己商品
	@Override
	public List<Product> findProductByUserId(Integer userId) {
		String sql = "select * from product where product_user_id = ?";
		return jdbcTemplate.query(findProductByUserIdSQl, new BeanPropertyRowMapper<>(Product.class), userId);
	}

	//根據產品Id搜尋產品資訊
	@Override
	public Optional<Product>findProductByProductId(Integer productId) {
		String sql = "select * from product where product_id = ?";
		try{
				Product product = jdbcTemplate.queryForObject(findProductByProductIdSql, new BeanPropertyRowMapper<>(Product.class), productId);
				return Optional.of(product);
		}catch (DataAccessException e) {
			Logger.info(e.toString());
		}
		return Optional.empty();
	}

	//商品價格高到低搜尋
	@Override
	public List<Product> findProductByHigh() {
		String sql = "select * from product order by product_price desc";
		return jdbcTemplate.query(findProductByHighSql, new BeanPropertyRowMapper<>(Product.class));
	}

	//商品價格低到高搜尋
	@Override
	public List<Product> findProductByLow() {
		String sql = "select * from product order by product_price";
		return jdbcTemplate.query(findProductByLowSql, new BeanPropertyRowMapper<>(Product.class));
	}

	//相同商品地點搜尋
	@Override
	public List<Product> findProductByPlace(String productPlace) {
		String sql = "select * from product where product_place = ?";
		return jdbcTemplate.query(findProductByPlaceSql, new BeanPropertyRowMapper<>(Product.class), productPlace);
	}

	//商品日期新到舊搜尋
	@Override
	public List<Product> findProductByNew() {
		String sql = "select * from product order by product_date desc";
		return jdbcTemplate.query(findProductByNewSql, new BeanPropertyRowMapper<>(Product.class));
	}

	//商品日期舊到新搜尋
	@Override
	public List<Product> findProductByOld() {
		String sql = "select * from product order by product_date";
		return jdbcTemplate.query(findProductByOldSql, new BeanPropertyRowMapper<>(Product.class));
	}

	//相同團體名稱搜尋
	@Override
	public List<Product> findProductbyIdolName(String idolName) {
		String sql = "select * from product where idol_name = ?";
		return jdbcTemplate.query(findProductbyIdolNameSql,new BeanPropertyRowMapper<>(Product.class), idolName);
	}

	//男團女團搜尋
	@Override
	public List<Product> findProductByGender(String gender) {
		String sql = "select * from product where gender = ?";
		return jdbcTemplate.query(findProductByGenderSql, new BeanPropertyRowMapper<>(Product.class), gender);
	}

	//根據產品類型搜尋
	@Override
	public List<Product> findProductByType(String productType) {
		String sql = "select * from product where product_type = ?";
		return jdbcTemplate.query(findProductByTypeSql, new BeanPropertyRowMapper<>(Product.class), productType);
	}

	//根據相同標籤搜尋
	@Override
	public List<Product> findProductByTag(String tag) {
		String sql = "select * from product where tag = ?";
		return jdbcTemplate.query(findProductByTagSql, new BeanPropertyRowMapper<>(Product.class), tag);
	}

	//關鍵字搜尋
	@Override
	public List<Product> findProductBySerch(String message) {
		String sql = "select * from product where product_name = %?%";
		return jdbcTemplate.query(findProductBySerchSql, new BeanPropertyRowMapper<>(Product.class), message);
	}

	//新增商品
	@Override
	public void saveProduct(Product product) {
		String sql = "insert into product(gender, idol_name, product_date, product_name, product_narrate, product_num, product_photo, product_place, product_price, product_type, product_user_id, tag) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			int rowcount = jdbcTemplate.update(saveProductSql, product.getGender(), product.getIdolName(), product.getProductDate(), product.getProductName(), product.getProductNarrate(),
											product.getProductNum(), product.getProductPhoto(), product.getProductPlace(), product.getProductPrice(), product.getProductType(), product.getProductUserId(), product.getTag());
			if(rowcount != 1) {
				throw new RuntimeException("新增失敗");
			}
		}catch (DataAccessException e) {
			Logger.info(e.toString());
		}
	}

	//修改商品
	@Override
	public void updateProduct(Product product) {
		String sql = "update product set gender = ?, idol_name = ?, product_date = ?, product_name = ?, product_narrate = ?, product_num = ?, product_photo = ?, product_place = ?, product_price = ?, product_type = ?, tag = ? where product_id = ?";
		try {
			int rowcount = jdbcTemplate.update(updateProductSql, product.getGender(), product.getIdolName(), product.getProductDate(), product.getProductName(), product.getProductNarrate(), 
												product.getProductNum(), product.getProductPhoto(), product.getProductPlace(), product.getProductPrice(), product.getProductType(), product.getTag(), product.getProductId());
			if(rowcount != 1) {
				throw new RuntimeException("更新失敗");
		
			}
		}catch (DataAccessException e) {
			Logger.info(e.toString());
		}
	}

	//刪除商品
	@Override
	public void deleteProduct(Integer productId) {
		String sql = "delete from product where product_id = ?";
		try {
			int rowcount = jdbcTemplate.update(deleteProductSql, productId);
			if(rowcount != 1) {
				throw new RuntimeException("刪除失敗");
			}
		}catch (DataAccessException e) {
			Logger.info(e.toString());
		}
	}

}
