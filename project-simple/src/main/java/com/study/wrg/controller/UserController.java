package com.study.wrg.controller;

import com.study.wrg.entity.User;
import com.study.wrg.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private Log logger = LogFactory.getLog(UserController.class);

    private final UserService userService;

    @ModelAttribute
    public Map model(){
        Map<String, String> objectObjectMap = new HashMap<>();

        return objectObjectMap;
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> users(){
        List<User> users = userService.selectAllUser();
        logger.info("users="+users);
        return users;
    }

    @GetMapping("/users/V2")
    public List<User> usersV2(){
        List<User> users = userService.selectAllUser();
        logger.info("users="+users);
        return users;
    }

    @GetMapping("/user")
    public User user(String id){
        User user = userService.selectUser(id);
        logger.info("user="+user);
        return user;
    }


    @PostMapping("/user/add")
    public String addForm(User user){
        boolean b = userService.addUser(user);
        logger.info("addForm : "+b);
        return b?"添加成功":"添加失败";
    }

    @PostMapping("/user/add/json")
    public String addJson(@RequestBody User user){
        boolean b = userService.addUser(user);
        logger.info("addJson : "+b);
        return b?"添加成功":"添加失败";
    }


    @PostMapping("/user/delete")
    //@DeleteMapping("/user/delete")
    public String delete(String id){
        return userService.deleteUser(id) ? "删除成功":"删除失败";
    }

    @PostMapping("/user/update")
    public String update(User user){
        return userService.updateUser(user) ? "更新成功":"更新失败";
    }
}
