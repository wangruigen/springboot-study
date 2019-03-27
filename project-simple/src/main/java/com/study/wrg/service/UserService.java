package com.study.wrg.service;

import com.study.wrg.entity.User;
import com.study.wrg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<User> selectAllUser(){
        return userRepository.selectAllUser();
    }

    public User selectUser(String id){
        return userRepository.selectUser(id);
    }

    public boolean addUser(User user){
        return userRepository.addUser(user);
    }

    public boolean deleteUser(String id){
        return userRepository.deleteUser(id);
    }

    public boolean updateUser(User user){
        return userRepository.updateUser(user);
    }
}
