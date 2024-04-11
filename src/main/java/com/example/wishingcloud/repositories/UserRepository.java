package com.example.wishingcloud.repositories;

import com.example.wishingcloud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
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

        String genderValue = u.getGender();
        if ("m".equals(genderValue)) {
            genderValue = "Male";
        } else if ("f".equals(genderValue)) {
            genderValue = "Female";
        }

        String formattedDateOfBirth = u.getDateOfBirth().toString(); // Format: "yyyy-MM-dd"

        jdbcTemplate.update(sql, u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword(), u.getAddress(),
                genderValue, formattedDateOfBirth);
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

    public String checkPass(String email) {
        String query = "SELECT password FROM users WHERE email = ?;";
        return jdbcTemplate.queryForObject(query, String.class, email);
        //String query = "SELECT password FROM users WHERE email = ?;";
        //RowMapper<String> rowMapper = new BeanPropertyRowMapper<>(String.class);
        //return jdbcTemplate.query(query, rowMapper, email);

    }


}
