package com.kopo.colorList1004;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//JSON형태로 객체 데이터를 반환한다
@RestController
public class ApiController {
	
	@GetMapping("/create_table")
	public String createTable() {
		
		return "";
	}

}
