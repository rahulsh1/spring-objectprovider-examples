package com.example.service;

public class JsonLogger implements LogService {

  @Override
  public void log(String data) {
    System.out.printf("{\"log\": { \"message\": \"%s\", \"timestamp\": %d } }", data, System.currentTimeMillis());
  }
}
