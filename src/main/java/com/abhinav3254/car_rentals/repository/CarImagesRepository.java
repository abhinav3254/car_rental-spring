package com.abhinav3254.car_rentals.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhinav3254.car_rentals.models.CarImages;


@Repository
public interface CarImagesRepository extends JpaRepository<CarImages, UUID> {

}
