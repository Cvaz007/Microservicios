package com.microservice.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hotel.entity.HotelEntity;
import com.microservice.hotel.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  @Autowired
  private HotelService hotelService;

  @PostMapping
  public ResponseEntity<HotelEntity> saveHotel(@RequestBody HotelEntity hotel) {
    return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
  }

  @GetMapping
  public ResponseEntity<List<HotelEntity>> findAllHotel() {
    return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.getAll());
  }

  @GetMapping("/{hotelId}")
  public ResponseEntity<HotelEntity> findHotel(@PathVariable String hotelId) {
    return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));
  }
}
