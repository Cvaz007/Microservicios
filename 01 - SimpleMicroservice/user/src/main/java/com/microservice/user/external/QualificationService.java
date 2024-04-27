package com.microservice.user.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservice.user.model.Qualification;

@FeignClient(name = "CALIFICACION-SERVICE")
public interface QualificationService {

  @PostMapping
  ResponseEntity<Qualification> saveQualification(Qualification qualification);

  @PostMapping("/qualification/{qualificationId}")
  ResponseEntity<Qualification> updateQualification(@PathVariable String qualificationId);

  @DeleteMapping("/qualification/{qualificationId}")
  void deleteQualification(@PathVariable String qualificationId);

}
