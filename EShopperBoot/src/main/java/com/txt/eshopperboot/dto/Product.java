package com.txt.eshopperboot.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	@NotBlank(message = "Product name is required")
	private String name;

	@Column(name = "DESCRIPTION")
	@NotBlank(message = "Description of product cannot is empty")
	@Size(min = 0, max = 255, message = "Description of product should be less than 255 characters")
	private String description;

	@Column(name = "PURCHASED_COUNT")
	private int purchasedCount;

	@Column(name = "QUANITY")
	@Min(value = 0, message = "Quanity of product cannot be negative")
	@Max(value = 10000000, message = "The amount of products is too large, not practical")
	private int quanity;

	@Column(name = "UNIT_PRICE")
	@Min(value = 1, message = "Price of product cannot be negative or zero")
	@Max(value = 1000000000, message = "Price of product is too large, not practical")
	private double unitPrice;

	@Column(name = "SALE_OFF")
	@Min(value = 0, message = "Percent sale off of product cannot be negative")
	@Max(value = 100, message = "Percent sale off of product cannot greater than 100")
	private int saleOff;

	@Column(name = "VIEWS")
	private int views;

	@Column(name = "CODE")
	private String code;

	@Column(name = "IS_ACTIVE")
	private boolean active;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@ManyToOne
	@NotNull
	@JoinColumn(nullable = false)
	private Category category;

	@Transient
	private MultipartFile file;

	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPurchasedCount() {
		return purchasedCount;
	}

	public void setPurchasedCount(int purchasedCount) {
		this.purchasedCount = purchasedCount;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getSaleOff() {
		return saleOff;
	}

	public void setSaleOff(int saleOff) {
		this.saleOff = saleOff;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
