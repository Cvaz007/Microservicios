package com.microservice.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hotel.entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, String> {

}
