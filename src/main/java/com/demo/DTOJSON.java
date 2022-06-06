package com.demo;

public class DTOJSON {
	private String quantity,name , image ;
	private Double priceOfficial , priceDiscout;
	public DTOJSON() {
	
	}
	public DTOJSON(String quantity, String name, String image, Double priceOfficial, Double priceDiscout) {
		super();
		this.quantity = quantity;
		this.name = name;
		this.image = image;
		this.priceOfficial = priceOfficial;
		this.priceDiscout = priceDiscout;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPriceOfficial() {
		return priceOfficial;
	}
	public void setPriceOfficial(Double priceOfficial) {
		this.priceOfficial = priceOfficial;
	}
	public Double getPriceDiscout() {
		return priceDiscout;
	}
	public void setPriceDiscout(Double priceDiscout) {
		this.priceDiscout = priceDiscout;
	}
}
