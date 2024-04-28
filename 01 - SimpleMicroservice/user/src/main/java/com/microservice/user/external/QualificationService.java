package com.microservice.user.external;

import com.microservice.user.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservice.user.model.Qualification;

import java.util.List;

@FeignClient(name = "CALIFICACION-SERVICE")
public interface QualificationService {
  @PostMapping
  ResponseEntity<Qualification> saveQualification(Qualification qualification);

  @PostMapping("/qualifications/{qualificationId}")
  ResponseEntity<Qualification> updateQualification(@PathVariable String qualificationId);

  @DeleteMapping("/qualifications/{qualificationId}")
  void deleteQualification(@PathVariable String qualificationId);

  @GetMapping("/qualifications/users/{qualificationId}")
  List<Qualification> findQualificationByUserId(@PathVariable String qualificationId);

}
