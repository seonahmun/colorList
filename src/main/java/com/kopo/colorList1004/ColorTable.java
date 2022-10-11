package com.kopo.colorList1004;

import java.util.ArrayList;
import java.util.Random;

public class ColorTable {
	
	//객체 갖고 오기
	Color color;
	
	int randomRed;
	int randomGreen;
	int randomBlue;
	
	String red16hex;
	String green16hex;
	String blue16hex;
	
	String rgb16hex;
	
	ColorTable(){
		
	}
	
	
	public ArrayList<Color> setRandomNumber(Color color) {
		
		//random 생성
		Random random = new Random();
		
		//ArrayList 생성
		ArrayList<Color> colorList = new ArrayList<Color>();
		
		for(int i=0; i<16; i++) {
			this.randomRed = random.nextInt(256); // random number: 0~255
			this.randomGreen = random.nextInt(256);
			this.randomBlue = random.nextInt(256);
			
			for(int j=0; j<1; j++) {
				color.setRed(this.randomRed);
				color.setGreen(this.randomGreen);
				color.setBlue(this.randomBlue);
				
				this.red16hex = Integer.toHexString(color.getRed());
				this.green16hex = Integer.toHexString(color.getGreen());
				this.blue16hex = Integer.toHexString(color.getBlue());
				
				this.rgb16hex = "#" + this.red16hex + this.green16hex + this.blue16hex;
				
				color.setRgbColor(this.rgb16hex);
				colorList.add(new Color(this.randomRed,this.randomGreen,this.randomGreen,this.rgb16hex));
			}
		}
		//ArrayList 출력 
		for(int i=0; i<colorList.size(); i++) {
			
			System.out.println("red: " + colorList.get(i).getRed());
			System.out.println("green: " + colorList.get(i).getGreen());
			System.out.println("blue: " + colorList.get(i).getBlue());
			System.out.println("rgbColor: " + colorList.get(i).getRgbColor());
		}
		
		return colorList;
	}
	
	

	

}
