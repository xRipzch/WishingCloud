package com.example.wishingcloud.services;

import com.example.wishingcloud.models.User;
import com.example.wishingcloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void addUser(User u){
        userRepository.addUser(u);
    }

    public List<User> getUsers(){
        return userRepository.getUsers();
    }

    public User getUser(int userId){
        return userRepository.getUser(userId);
    }

    public String checkPass(String email, String password) {
            String dbPassword = userRepository.checkPass(email);
            if(password.equals(dbPassword)){
                return "UserApproved";
            } else if (dbPassword.equals("UserNotFound")){
                return "NoUserFound";
            } else {
                return "WrongPassWord";
            }

    }

    public int getUserID(String email) {
        return userRepository.getUserID(email);
    }

    /*public boolean checkPass(String email, String password) {
        try {
            String dbPassword = userRepository.checkPass(email);
            if(password.equals(dbPassword)){
                return true;
            }else if (dbPassword == null) {
                return false;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }*/
}
