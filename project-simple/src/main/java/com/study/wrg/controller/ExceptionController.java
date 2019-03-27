package com.study.wrg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//restful
@RestController
public class ExceptionController {

    @GetMapping("/ex")
    public String exception() throws Exception {
        throw new Exception("this is exception");
    }

    /**
     * 如果这是一个rest api ，客户端调用时，必须返回错误信息，不然客户端出现异常
     * @return
     */
    @GetMapping("/exx")
    public String exceptionx() {
        try {
            throw new Exception("this is exception");
        } catch (Exception e) {
            return "500xxx";
        }
    }
}
