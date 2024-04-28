package com.microservice.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Qualification {
  
  private String id;
  private String userId;
  private String hotelId;
  private int qualification;
  private String observation;

  private Hotel hotel;
}
