package com.kopo.colorList1004;

public class Color {
	
	/**
	 * 색상 변수 선언
	 * int red, green, blue
	 * String rgbColor
	 * 
	 * 22.10.11 추가
	 * int idx
	 * String datetime
	 */
	private int red;
	private int green;
	private int blue;
	private String rgbColor;
	private int idx;
	private String datetime;

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
	/**
	 * 순번을 리턴한다
	 * @return 순번 
	 */
	public int getIdx() {
		return idx;
	}
	/**
	 * 순번을 저장한다
	 * @param idx
	 */
	public void setIdx(int idx) {
		this.idx = idx;
	}
	/**
	 * 시간을 리턴한다
	 * @return 시간 
	 */
	public String getDatetime() {
		return datetime;
	}
	/**
	 * 시간을 저장한다
	 * @param datetime
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
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
	
	Color(int idx, String rgbColor, String datetime){
		this.idx = idx;
		this.rgbColor = rgbColor;
		this.datetime = datetime;
	}
	
	
	

}
