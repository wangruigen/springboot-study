package com.study.wrg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping({"/","/index"})
    public String index(){
        return "hello world";
    }

    @ModelAttribute
    public Map<String,Object> init(){
        Map<String,Object> map = new HashMap<>();
        for (int i=0;i<10;i++){
            map.put("key"+i,"value"+i);
        }
        return map;
    }

    @GetMapping("/map")
    public Map<String,Object> getMap(@ModelAttribute Map map){
        System.out.println(map);
        return map;
    }
   /* @GetMapping("/map")
    public Map<String,Object> getMap(Map map){
        System.out.println(map);
        return map;
    }*/
}
