package com.kopo.colorList1004;

public class Color {
	
	/**
	 * 색상 변수 선언
	 * int red, green, blue
	 * String rgbColor
	 */
	private int red;
	private int green;
	private int blue;
	private String rgbColor;
	
	/**
	 * red 색상값을 리턴한다
	 * @return red색상값 
	 */
	public int getRed() {
		return red;
	}
	/**
	 * red 색상값을 저장한다
	 * @param red
	 */
	public void setRed(int red) {
		this.red = red;
	}
	/**
	 * green 색상값을 리턴한다
	 * @return green 색상값
	 */
	public int getGreen() {
		return green;
	}
	/**
	 * green 색상값을 저장한다
	 * @param green
	 */
	public void setGreen(int green) {
		this.green = green;
	}
	/**
	 * blue 색상값을 리턴한다
	 * @return blue 색상값
	 */
	public int getBlue() {
		return blue;
	}
	/**
	 * blue 색상값을 저장한다
	 * @param blue
	 */
	public void setBlue(int blue) {
		this.blue = blue;
	}
	/**
	 * RGB 색상값을 리턴한다
	 * @return RGB 색상값
	 */
	public String getRgbColor() {
		return rgbColor;
	}
	/**
	 * RGB 색상값을 저장한다
	 * @param rgbColor
	 */
	public void setRgbColor(String rgbColor) {
		this.rgbColor = rgbColor;
	}
	
	//생성자
	Color(){
		
	}
	
	Color(int red, int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	Color(int red, int green, int blue, String rgbColor){
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.rgbColor = rgbColor;
	}
	
	
	

}
