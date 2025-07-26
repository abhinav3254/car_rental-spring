package com.abhinav3254.car_rentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav3254.car_rentals.models.Car;
import com.abhinav3254.car_rentals.service.CarService;


@RequestMapping("/cars")
@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	
	@PostMapping
	public Car createCar(@RequestBody Car car) {
		return carService.createCar(car);
	}
	
}
