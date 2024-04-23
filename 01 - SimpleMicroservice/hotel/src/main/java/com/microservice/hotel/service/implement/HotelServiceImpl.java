package com.microservice.hotel.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.entity.HotelEntity;
import com.microservice.hotel.exception.ResourceNotFoundException;
import com.microservice.hotel.repository.HotelRepository;
import com.microservice.hotel.service.HotelService;

import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

  @Autowired
  private HotelRepository hotelRepository;

  @Override
  public HotelEntity create(HotelEntity hotel) {
    String hotelId = UUID.randomUUID().toString();
    hotel.setId(hotelId);
    return hotelRepository.save(hotel);
  }

  @Override
  public List<HotelEntity> getAll() {
    return hotelRepository.findAll();
  }

  @Override
  public HotelEntity get(String id) {
    return hotelRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with the ID : " + id));

  }

}
