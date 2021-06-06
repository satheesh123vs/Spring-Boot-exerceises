package com.example.demo.configs;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

	final static Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseBody
	public ModelAndView myError(Exception exception) {
		logger.error("----Caught IOException----" + exception);
		return new ModelAndView("error", "exceptionMessage", exception);
	}
}