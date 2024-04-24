package com.microservice.qualification.service;

import java.util.List;

import com.microservice.qualification.entity.QualificationEntity;

public interface QualificationService {

  QualificationEntity create(QualificationEntity qualification);

  List<QualificationEntity> getQualification();

  List<QualificationEntity> getQualificationByUserId(String userId);

  List<QualificationEntity> getQualificationByHotelId(String hotelId);
}
