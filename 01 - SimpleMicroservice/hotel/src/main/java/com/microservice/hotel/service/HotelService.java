package com.microservice.hotel.service;

import com.microservice.hotel.entity.HotelEntity;

import java.util.List;

public interface HotelService {
  
  HotelEntity create(HotelEntity hotel);
  List<HotelEntity> getAll();
  HotelEntity get(String id);
}
