package com.kopo.colorList1004;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//Controller 어노테이션 붙여준다.
@Controller
public class ColorMainController {
	
	@GetMapping("/")
	public String colorTable(Model model, HttpServletRequest request) {
		
		//Random
		Random random = new Random();
		
		//random 값 색상 변수에 저장 (ramdom값이 계속 변해야 함)
		Color color = new Color();
		
		//ArrayList 생성
		ArrayList<Color> colorList = new ArrayList<Color>();
		
		int randomRed = 0;
		int randomGreen = 0;
		int randomBlue = 0;
		
		String red16hex = "";
		String green16hex = "";
		String blue16hex = "";
		String rgb16hex = "";
		
		for(int i=0; i<16; i++) {
			randomRed = random.nextInt(256);
			randomGreen = random.nextInt(256);
			randomBlue = random.nextInt(256);
			
			System.out.println(i + "번째");
			
			for(int j=0; j<1; j++) {
				color.setRed(randomRed);
				color.setGreen(randomGreen);
				color.setBlue(randomBlue);
				
				//10진수 -> 16진수 변환
				red16hex = Integer.toHexString(color.getRed());
				green16hex = Integer.toHexString(color.getGreen());
				blue16hex = Integer.toHexString(color.getBlue());
			
				//16진수 합치기
				rgb16hex = red16hex + green16hex + blue16hex;
				
				//길이확인
				System.out.println("rgb16hex.length(): " + rgb16hex.length());
				
				if(rgb16hex.length() < 6) {
					rgb16hex = "#0" + rgb16hex;
				}else {
					rgb16hex = "#" + rgb16hex;
				}
				
				color.setRgbColor(rgb16hex);
				
				//ArrayList에 담기
				colorList.add(new Color(randomRed,randomGreen,randomBlue,rgb16hex));
			
			}
			System.out.println("============");
			System.out.println("red: " + color.getRed());
			System.out.println("green: " + color.getGreen());
			System.out.println("blue: " + color.getBlue());
			System.out.println("RGB code: " + color.getRgbColor());
			System.out.println("============");
		}
		
		//ArrayList 출력 
		for(int i=0; i<colorList.size(); i++) {
			
			System.out.println("ArrayList " + i + "번째====");
			System.out.println("red: " + colorList.get(i).getRed());
			System.out.println("green: " + colorList.get(i).getGreen());
			System.out.println("blue: " + colorList.get(i).getBlue());
			System.out.println("rgbColor: " + colorList.get(i).getRgbColor());
		}
		
		model.addAttribute("colorList", colorList);
				
		return "main";
	}
	
	@RequestMapping(value = "/colorLog")
	public String colorLog(Model model) throws URISyntaxException, SQLException {
		
		//db연결
		URI dbUri = new URI(System.getenv("DATABASE_URL"));
		
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
				
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
		
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		
		//ArrayList 생성
//		ArrayList<Color> colorList = new ArrayList<Color>();
		
		//select 자꾸 오류남...
//		String query = "SELECT * FROM colorSelect" + " WHERE ?;";
//		PreparedStatement preparedStatement = connection.prepareStatement(query);
//		preparedStatement.setInt(1, 1);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		while(resultSet.next()) {
//			int idx = resultSet.getInt("idx");
//			String rgbCode = resultSet.getString("rgbCode");
//			String datetime = resultSet.getString("datetime");
//			colorList.add(new Color(idx, rgbCode, datetime));
//		}
//		
//		preparedStatement.close();
//		connection.close();
//		
//		model.addAttribute("colorList",colorList);
//		
//		return "colorLog";
		
		String query = "SELECT * FROM colorSelect" + " WHERE ?;";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, 1);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		StringBuffer colorList = new StringBuffer();
		while(resultSet.next()) {
			int idx = resultSet.getInt("idx");
			String rgbCode = resultSet.getString("rgbCode");
			String datetime = resultSet.getString("datetime");
			String rowString = "<li style='background-color: " + rgbCode + ";'>" + rgbCode + "<br />" + datetime + "</li>";
			colorList.append(rowString);
		}
		preparedStatement.close();
		connection.close();
		
		model.addAttribute("colorList", colorList);
		return "colorLog";
	}

}
