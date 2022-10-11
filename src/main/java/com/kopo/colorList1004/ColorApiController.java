package com.kopo.colorList1004;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//RestController의 주용도는 JSON 형태로 객체 데이터를 반환
@RestController
public class ColorApiController {
	
	//GetMapping 말고 RequestMapping 사용
	@RequestMapping("/createTable")
	public Map<String, String> createTable(Model model) throws URISyntaxException, SQLException, JsonProcessingException {
		
		//db연결
		//heroku-Setting-Config Vars설정
		URI dbUri = new URI(System.getenv("DATABASE_URL"));
		
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
				
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
		
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		
		//create
		String query = "CREATE TABLE colorSelect(idx serial PRIMARY KEY, rgbCode VARCHAR(12), datetime VARCHAR(20));";
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		
		statement.close();
		connection.close();
		
		//map 객체 선언
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("message", "success");
		
		
		//JSON타입으로 변환할 수 있는 함수 선언
		ObjectMapper objectMapper = new ObjectMapper();
		
		String mapJSON = objectMapper.writeValueAsString(map);
		
		System.out.println(mapJSON);
		
		
		return map;
	}
	
	@RequestMapping("/colorSelect")
	public HashMap<String, String> selectColor(@RequestParam String rgbCode) throws URISyntaxException, SQLException {
		
		//현재시간
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = formatter.format(date);
		
		HashMap<String, String> map = new HashMap<String, String>(); 
		
		//db연결
		URI dbUri = new URI(System.getenv("DATABASE_URL"));
		
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
				
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
		
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		
		//insert
		String query = "INSERT INTO colorSelect(rgbCode, datetime) VALUES(?,?);";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		//이름에 홑따옴표가 들어가는 경우 직접입력하는 것보다 테이블에서 가져오기 때문에 데이터가 정확해진다.
		
		//preparedStatement.set타입'?에 올 타입'(첫번째=1 두번째=2 ..., 첫번째 ?에 올 값 두번째 ?에 올 값 ...
		preparedStatement.setString(1, rgbCode);
		preparedStatement.setString(2, datetime);
		
		//executeUpdate(String sql)
		//조회문(select, show 등)을 제외한 create, drop, insert, delete, update 등등 문을 처리할 때 사용한다.
		preparedStatement.executeUpdate();
		
		//참고)executeQuery(String sql)
		//조회문(select, show 등)을 실행할 목적으로 사용한다.

		preparedStatement.close();
		connection.close();
				
		return map;
	}

}
