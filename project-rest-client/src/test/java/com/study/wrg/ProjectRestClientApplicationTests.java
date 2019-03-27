package com.study.wrg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.wrg.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRestClientApplicationTests {
    @Autowired
    RestTemplate restTemplate;

    private Log log = LogFactory.getLog(ProjectRestClientApplicationTests.class);

    /**
     * 查询所有用户
     */
    @Test
    public void getUserList() {
        String userJson = restTemplate.getForObject("http://192.168.18.1:9999/users", String.class);
        log.info("userJson "+userJson);
        //反序列化成User对象
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //[{"id":"1","name":"name1","age":1},{"id":"2","name":"name2","age":2},{"id":"3","name":"name3","age":3},{"id":"4","name":"name4","age":4},{"id":"5","name":"name5","age":5}]
            List<User> list = objectMapper.readValue(userJson,new TypeReference<List<User>>(){});
            list.forEach(user ->  log.info("user "+user) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userClient() {
        String userJson = restTemplate.getForObject("http://192.168.18.1:9999/user?id=1", String.class);
        log.info("userJson "+userJson);
        //反序列化成User对象
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //{"id":"1","name":"name1","age":1}
            User user = objectMapper.readValue(userJson, User.class);
            log.info("user "+user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exClient() {
        String userJson = restTemplate.getForObject("http://localhost:9999/exx", String.class);
        System.out.println("userJson "+userJson);
    }

    /**
     * 添加用户by form(表单提交)
     */
    @Test
    public void addUserForm(){
        HttpHeaders headers = new HttpHeaders();
        //  MediaType.APPLICATION_FORM_URLENCODED
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("name", "usersClient");
        map.add("age", "20");
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> postForObject = restTemplate.postForEntity("http://192.168.18.1:9999/user/add", entity, String.class);
        log.info("postForObject "+postForObject.getBody());
    }

    /**
     * 添加用户by json param
     */
    @Test
    public void addUserJson() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        //  MediaType.APPLICATION_JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        User user = new User("helloword",100);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBoby = objectMapper.writeValueAsString(user);
        log.info("requestBoby "+requestBoby);
        HttpEntity<String> entity = new HttpEntity<>(requestBoby, headers);
        ResponseEntity<String> postForObject = restTemplate.postForEntity("http://192.168.18.1:9999/user/add/json", entity, String.class);
        log.info("postForObject "+postForObject.getBody());
    }
}
