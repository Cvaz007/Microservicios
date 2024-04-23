package com.microservice.qualification.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("qualification")
public class QualificationEntity {

  @Id
  private String id;
  private String userId;
  private String hotelId;
  private int qualification;
  private String observation;

}
