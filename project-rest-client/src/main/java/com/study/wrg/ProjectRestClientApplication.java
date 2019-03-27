package com.study.wrg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectRestClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectRestClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    /*@Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate get() {
        return restTemplateBuilder.build();
    }

    @Autowired
    RestTemplate restTemplate;



    public void userList() {
        String userList = restTemplate.getForObject("http://localhost:9999/users", String.class);
        System.out.println(userList);
    }

    public void addUser() {
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> map = new LinkedMultiValueMap<String,String>();
        map.add("name", "usersClient");
        map.add("age", "20");
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<MultiValueMap<String,String>>(map,headers);
        ResponseEntity<String> postForObject = restTemplate.postForEntity("http://localhost:9999/user/add", entity, String.class);
        System.out.println("postForObject "+postForObject.getBody());
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(1);
        userList();//获取userList
        System.out.println(2);
        addUser();//添加User
        System.out.println(3);
        userList();//再次获取userList
    }*/
}
