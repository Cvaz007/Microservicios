package com.microservice.qualification.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.qualification.entity.QualificationEntity;

public interface QualificationRepository extends MongoRepository<QualificationEntity, String> {

  List<QualificationEntity> findByUserId(String userId);

  List<QualificationEntity> findByHotelId(String hotelId);
}
