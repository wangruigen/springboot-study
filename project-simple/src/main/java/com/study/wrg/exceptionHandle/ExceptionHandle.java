package com.study.wrg.exceptionHandle;

import java.util.HashMap;
import java.util.Map;

import com.study.wrg.controller.UserController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandle {
	Log logger = LogFactory.getLog(ExceptionHandle.class);

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Map<String,Object> exceptionHandle(Exception ex, HttpServletRequest request, HttpServletResponse response){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("code", response.getStatus());
		map.put("message", ex.getMessage());
		logger.error("exception :"+map,ex);
		return map;
	}

	//@ExceptionHandler(value=Exception.class)
	/*@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,Object> responseError(Exception ex, HttpServletRequest request, HttpServletResponse response){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
		map.put("500", "服务器错误："+ex.getMessage());
		return map;
	}*/
}
