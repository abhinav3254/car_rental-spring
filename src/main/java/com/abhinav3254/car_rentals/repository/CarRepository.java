package com.abhinav3254.car_rentals.repository;

import com.abhinav3254.car_rentals.models.Car;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

}
