package com.digiuncle.digiuncle.entity;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_list")
public class Products {
	@Id
	@Column(name = "product_id", nullable = false, unique = true)
	private UUID product_id;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="product_category")
	private String product_category;
	
	@Column(name="product_MRPprice")
	private Double product_MRPprice;
	
	@Column(name="product_discounted_price")
	private Double product_discounted_price;
	
	@Column(name="product_brand")
	private String product_brand;
	
	@Column(name="product_size")
	private String product_size;
	
	@Column(name="product_color")
	private String product_color;
	
	@Column(name="product_slug")
	private String product_slug;
	
	@Column(name="product_quantity")
	private int product_quantity;
	
	@Column(name="created_at")
	private Timestamp created_at;
	
	@Column(name="updated_at")
	private Timestamp updated_at;

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public double getProduct_MRPprice() {
		return product_MRPprice;
	}

	public void setProduct_MRPprice(double product_MRPprice) {
		this.product_MRPprice = product_MRPprice;
	}

	public double getProduct_discounted_price() {
		return product_discounted_price;
	}

	public void setProduct_discounted_price(double product_discounted_price) {
		this.product_discounted_price = product_discounted_price;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public String getProduct_size() {
		return product_size;
	}

	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}

	public String getProduct_color() {
		return product_color;
	}

	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}

	public String getProduct_slug() {
		return product_slug;
	}

	public void setProduct_slug(String product_slug) {
		this.product_slug = product_slug;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Products(UUID product_id, String product_name, String product_category, double product_MRPprice,
			double product_discounted_price, String product_brand, String product_size, String product_color,
			String product_slug, int product_quantity, Timestamp created_at, Timestamp updated_at) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_category = product_category;
		this.product_MRPprice = product_MRPprice;
		this.product_discounted_price = product_discounted_price;
		this.product_brand = product_brand;
		this.product_size = product_size;
		this.product_color = product_color;
		this.product_slug = product_slug;
		this.product_quantity = product_quantity;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Products() {
		this.product_id = UUID.randomUUID();
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		ZonedDateTime nowIST = ZonedDateTime.now(zoneId);
		this.created_at = Timestamp.valueOf(nowIST.toLocalDateTime());
	}
	
}
