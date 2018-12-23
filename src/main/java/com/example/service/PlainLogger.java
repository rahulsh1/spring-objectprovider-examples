package com.example.service;

public class PlainLogger implements LogService {

  @Override
  public void log(String data) {
    System.out.printf("Data [%s] at %d%n", data, System.currentTimeMillis());
  }
}
