package com.microservice.user.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.microservice.user.external.QualificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.entity.UserEntity;
import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.external.HotelService;
import com.microservice.user.model.Hotel;
import com.microservice.user.model.Qualification;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  //private RestTemplate restTemplate;
  private QualificationService qualificationService;

  @Autowired
  private HotelService hotelService;

  @Autowired
  private UserRepository userRepository;

  private Logger logger = LoggerFactory.getLogger(UserService.class);

  @Override
  public List<UserEntity> getAllUsers() {

    return userRepository.findAll();
  }

  @Override
  public UserEntity  getUser(String userId) {

    UserEntity user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not fount with the ID: " + userId));

    Qualification[] userQualification = qualificationService.findQualificationByUserId(userId).toArray(new Qualification[0]);
            /*restTemplate
        .getForObject("http://CALIFICACION-SERVICE/qualifications/users/" + user.getUserId(), Qualification[].class);
    */
    logger.info("{}", userQualification);

    List<Qualification> qualifications = Arrays.stream(userQualification).collect(Collectors.toList());

    List<Qualification> qualificationsList = qualifications.stream().map(qualification -> {
      System.out.println(qualification.getHotelId());

      Hotel hotel = hotelService.getHotel(qualification.getHotelId());

      qualification.setHotel(hotel);
      return qualification;
    }).collect(Collectors.toList());

    user.setQualifications(qualificationsList);
    return user;
  }

  @Override
  public UserEntity saveUser(UserEntity user) {

    String randomUserId = UUID.randomUUID().toString();
    user.setUserId(randomUserId);

    return userRepository.save(user);
  }

}
