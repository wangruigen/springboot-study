package com.study.wrg.controller;

import com.study.wrg.entity.GameRole;
import com.study.wrg.service.GameRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameRoleController {

    private Log log = LogFactory.getLog(GameRoleController.class);

    @Autowired
    GameRoleService gameRoleService;

    @GetMapping("/userList")
    public List<GameRole> userList() throws Exception {
        log.info("==============userList()===========");
        List<GameRole> gameRoleList = gameRoleService.getGameRoleList();
        gameRoleList.forEach(gameRole -> log.info(gameRole));
        return gameRoleList;
    }

    @GetMapping("/user/{id}")
    public GameRole user(@PathVariable("id") Integer id) throws Exception {
        GameRole gameRole = gameRoleService.getGameRole(id);
        return gameRole;
    }

    @PostMapping("/user/add")
    public String addUser(GameRole gameRole) throws Exception {
        boolean b = gameRoleService.addGameRole(gameRole);
        return b?"success":"false";
    }

}
