package com.kopo.colorList1004;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//RestController의 주용도는 JSON 형태로 객체 데이터를 반환
@RestController
public class ColorApiController {
	
	//create
	@GetMapping("/createTable")
	public String createTable(Model model) throws URISyntaxException, SQLException, JsonProcessingException {
		
		URI dbUri = new URI(System.getenv("DATABASE_URL"));
		
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
		
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		
		String query = "CREATE TABLE colorSelect(idx AUTO_INCREMENT PRIMARY KEY, rgbCode VARCHAR(12), datetime VARCHAR(20));";
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		
		statement.close();
		connection.close();
		
		//map 객체 선언
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("message", "success");
		
		
		//JSON타입으로 변환할 수 있는 함수 선언
		ObjectMapper objectMapper = new ObjectMapper();
		
		String mapJSON = objectMapper.writeValueAsString(map);
		
		System.out.println(mapJSON);
		
		
		return mapJSON;
	}
	
	//insert

}