package com.microservice.qualification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.qualification.entity.QualificationEntity;
import com.microservice.qualification.service.QualificationService;

@RestController
@RequestMapping("/qualifications")
public class QualificationController {

  @Autowired
  private QualificationService qualificationService;

  @PostMapping
  public ResponseEntity<QualificationEntity> saveQualification(@RequestBody QualificationEntity qualification) {
    return ResponseEntity.status(HttpStatus.CREATED).body(qualificationService.create(qualification));
  }

  @GetMapping
  public ResponseEntity<List<QualificationEntity>> findQualification() {
    return ResponseEntity.ok(qualificationService.getQualification());
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<List<QualificationEntity>> findQualificationByUserId(@PathVariable String userId) {
    return ResponseEntity.ok(qualificationService.getQualificationByUserId(userId));
  }

  @GetMapping("/hotels/{hotelId}")
  public ResponseEntity<List<QualificationEntity>> findQualificationByHotelId(@PathVariable String hotelId) {
    return ResponseEntity.ok(qualificationService.getQualificationByHotelId(hotelId));
  }

}
