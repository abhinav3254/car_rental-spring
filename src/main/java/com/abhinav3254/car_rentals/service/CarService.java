package com.abhinav3254.car_rentals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinav3254.car_rentals.models.Car;
import com.abhinav3254.car_rentals.models.CarImages;
import com.abhinav3254.car_rentals.repository.CarImagesRepository;
import com.abhinav3254.car_rentals.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarImagesRepository carImagesRepository;
	
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	public Car createCar(Car car) {
	    List<CarImages> images = car.getImages();  // extract images
	    car.setImages(null);                       // detach to prevent circular save

	    Car savedCar = carRepository.save(car);    // save car first

	    for (CarImages image : images) {
	        image.setCar(savedCar);                // attach car to each image
	    }

	    carImagesRepository.saveAll(images);       // save all images

	    savedCar.setImages(images);                // reattach for response (optional)

	    return savedCar;
	}


}
