package com.example.basic;

import com.example.service.LogService;
import org.springframework.stereotype.Component;

@Component
public class ExampleOne {

  private final LogService logService;

  public ExampleOne(LogService logService) {
    this.logService = logService;
  }

  public void runApps() {
    logService.log("some data");
  }
}
