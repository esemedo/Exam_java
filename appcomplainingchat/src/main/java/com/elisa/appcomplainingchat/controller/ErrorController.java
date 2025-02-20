package com.elisa.appcomplainingchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	  @GetMapping("/error-404")
	    public String handle404() {
	        return "error/404";
	    }
	  @GetMapping("/error-500")
	    public String handle500() {
	        return "error/500";
	    }
}
