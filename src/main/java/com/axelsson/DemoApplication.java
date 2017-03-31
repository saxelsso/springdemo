package com.axelsson;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration

@SpringBootApplication
public class DemoApplication {

    	@RequestMapping("/")
    	String home() {
      		return "Hello Root Directory!";
    	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
