package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController						// REST 컨트롤러 기능을 수행 (데이터를 반환)
public class HelloController {
	
	// @RequestMapping(path="/", method=RequestMethod.GET)
	@GetMapping("/")				// 해당 메서드를 실행할 수 있는 주소를 설정
	public String hello() {
		return "Hello World !!!";
	}

}

