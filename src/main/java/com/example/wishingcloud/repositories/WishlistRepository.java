package com.example.wishingcloud.repositories;

import com.example.wishingcloud.models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class WishlistRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addWishlist(int userId, Wishlist w) {
        String sql = "INSERT INTO wishlists (user_id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, w.getName());
    }

    public List<Wishlist> getWishlists(int userId) {
        String sql = "SELECT * FROM wishlists WHERE user_id = ?";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.query(sql, rowMapper, userId);
    }

    public Wishlist getWishlist(int wishlistId) {
        String query = "SELECT * FROM wishlists WHERE wishlist_id = ?;";
        RowMapper<Wishlist> rowMapper = new BeanPropertyRowMapper<>(Wishlist.class);
        return jdbcTemplate.queryForObject(query, rowMapper, wishlistId);

    }

}
