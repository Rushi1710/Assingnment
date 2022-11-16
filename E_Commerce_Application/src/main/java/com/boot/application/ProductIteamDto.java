package com.boot.application;

public class ProductIteamDto {

	private int productId;
	private String description;
	private String productName;
	private String image;
	private int price;
	private int quantity;

	public ProductIteamDto() {

	}

	public ProductIteamDto(int productId, String description, String productName, String image, int price,
			int quantity) {
		super();
		this.productId = productId;
		this.description = description;
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductItems [productId=" + productId + ", description=" + description + ", productName=" + productName
				+ ", image=" + image + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
