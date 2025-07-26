package com.abhinav3254.car_rentals.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "car")
@Data
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String name;
	
	private String brand;
	
	private String model;
	
	private Integer year;
	
	private String color;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "body_type", columnDefinition = "body_type_enum")
	@ColumnTransformer(write = "?::body_type_enum")
	private BodyType bodyType;

	@Enumerated(EnumType.STRING)
	@Column(name = "fuel_type", columnDefinition = "fuel_type_enum")
	@ColumnTransformer(write = "?::fuel_type_enum")
	private FuelType fuelType;

	@Enumerated(EnumType.STRING)
	@Column(name = "transmission", columnDefinition = "transmission_enum")
	@ColumnTransformer(write = "?::transmission_enum") 
	private Transmission transmission;
	
	private String mileage;
	
	private Double price;
	
	private Integer airbags;
	
	@OneToMany
	@JoinColumn(name = "car_id")
	@JsonManagedReference
	private List<CarImages> images;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAirbags() {
		return airbags;
	}

	public void setAirbags(Integer airbags) {
		this.airbags = airbags;
	}

	public List<CarImages> getImages() {
		return images;
	}

	public void setImages(List<CarImages> images) {
		this.images = images;
	}

}
