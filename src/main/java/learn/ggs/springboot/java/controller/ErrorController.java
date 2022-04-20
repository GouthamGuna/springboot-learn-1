package learn.ggs.springboot.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	
	@GetMapping("/error")
	public String Error () {
		return "error";
	}

}
