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

    public void addProduct(String name, String url, String description, double price, int amount, int wishlistId) {
        String sql = "INSERT INTO products (wishlist_id, name, url, description, price, amount) VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, wishlistId, name, url, description, price, amount);
    }

    public List<Product> getProducts(int wishlistId) {
        String sql = "SELECT * FROM products WHERE wishlist_id = ?;";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.query(sql, rowMapper, wishlistId);
    }

    public Product getProduct(int productId) {
        String query = "SELECT * FROM products WHERE product_id = ?;";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.queryForObject(query, rowMapper, productId);

    }

    public void deleteProductFromWishlist(int productId){
        String sql = "DELETE FROM products WHERE product_id = ?;";
        jdbcTemplate.update(sql, productId);
    }

    public void editProductFromWishlist(String name, String url, String description, double price, int amount, int productId){
        String sql = "UPDATE products SET name = ?, url = ?, description = ?, price = ?, amount = ? WHERE product_id = ?;";
        jdbcTemplate.update(sql,name,url,description,price,amount,productId);
    }

    public Integer getWishListIdFromProduct(int productId) {
        String query ="SELECT wishlist_id from products WHERE product_id = ?;";
        return jdbcTemplate.queryForObject(query, Integer.class, productId);
    }

}
