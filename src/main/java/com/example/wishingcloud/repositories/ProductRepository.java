package com.example.wishingcloud.repositories;

import com.example.wishingcloud.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addProduct(Product p, int wishlistId) {
        String sql = "INSERT INTO products (wishlist_id, name, url, description, price, amount) VALUES (?, ?, ?, ?, ?, ?) ";
        jdbcTemplate.update(sql, wishlistId, p.getName(), p.getUrl(), p.getDescription(), p.getPrice(), p.getAmount());
    }

    public List<Product> getProducts(int wishlistId) {
        String sql = "SELECT * FROM products WHERE wishlist_id = ?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.query(sql, rowMapper, wishlistId);
    }

    public Product getProduct(int productId) {
        String query = "SELECT * FROM products WHERE product_id = ?;";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.queryForObject(query, rowMapper, productId);

    }

}
