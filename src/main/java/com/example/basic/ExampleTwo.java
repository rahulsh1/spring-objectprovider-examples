package com.example.basic;

import com.example.service.LogService;
import org.springframework.beans.factory.ObjectProvider;

public class ExampleTwo {

  private final ObjectProvider<LogService> logService;

  public ExampleTwo(ObjectProvider<LogService> logService) {
    this.logService = logService;
  }

  public void runApps() {
    logService.ifAvailable(e -> e.log("some data"));
  }

  public int numDependencies() {
    int[] count = {0};
    logService.stream().forEach(e -> count[0]++);
    return count[0];
  }
}
