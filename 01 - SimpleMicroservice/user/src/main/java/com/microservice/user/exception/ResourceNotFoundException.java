package com.microservice.user.exception;

public class ResourceNotFoundException extends RuntimeException{

  public ResourceNotFoundException() {
    super("Resource not found in the server!");
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
