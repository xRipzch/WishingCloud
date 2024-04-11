package com.example.wishingcloud.repositories;

import com.example.wishingcloud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(User u) {
        String sql = "INSERT INTO users (first_name, last_name, email, password, address, gender, date_of_birth)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, u.getFirstName(),u.getLastName(),u.getEmail(),u.getAddress(),
                u.getDateOfBirth(),u.getGender(),u.getPassword());
    }

    public List<User> getUsers() { // TODO SKAL ÆNDRES??
        String sql = "SELECT * FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public User getUser(int userId) {
        String query = "SELECT * FROM users WHERE user_id = ?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, userId);

    }
    public Integer getUserID(String email) {
        String query = "SELECT user_id FROM users WHERE email = ?;";
        return jdbcTemplate.queryForObject(query, Integer.class, email);
    }

    public String checkPass(String email) {
        try {
            String query = "SELECT password FROM users WHERE email = ?;";
            return jdbcTemplate.queryForObject(query, String.class, email);
        } catch (EmptyResultDataAccessException e) {
            return "UserNotFound";
        }
    }

}
