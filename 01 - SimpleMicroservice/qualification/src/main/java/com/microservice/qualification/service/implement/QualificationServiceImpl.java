package com.microservice.qualification.service.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.qualification.entity.QualificationEntity;
import com.microservice.qualification.repository.QualificationRepository;
import com.microservice.qualification.service.QualificationService;

@Service
public class QualificationServiceImpl implements QualificationService {

  @Autowired
  private QualificationRepository qualificationRepository;

  @Override
  public QualificationEntity create(QualificationEntity qualification) {
    String randomId = UUID.randomUUID().toString();
    qualification.setId(randomId);
    return qualificationRepository.save(qualification);
  }

  @Override
  public List<QualificationEntity> getQualification() {
    return qualificationRepository.findAll();

  }

  @Override
  public List<QualificationEntity> getQualificationByUserId(String userId) {
    return qualificationRepository.findByUserId(userId);

  }

  @Override
  public List<QualificationEntity> getQualificationByHotelId(String hotelId) {
    return qualificationRepository.findByHotelId(hotelId);

  }

}
