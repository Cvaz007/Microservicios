package com.microservice.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;
import java.util.ArrayList;

import com.microservice.user.model.Qualification;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @Column(name = "id")
  private String userId;

  @Column(name = "name", length = 20)
  private String name;

  private String email;

  private String information;

  @Transient
  private List<Qualification> qualifications = new ArrayList<>();

}
