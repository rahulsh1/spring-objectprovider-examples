package com.example.basic;

import com.example.service.LogService;
import org.springframework.beans.factory.ObjectProvider;

public class ExampleFive {

  private final ObjectProvider<LogService> logService;

  public ExampleFive(ObjectProvider<LogService> logService) {
    this.logService = logService;
  }

  public void runApps() {
    logService.ifAvailable(e -> e.log("some app data with " + getClass().getSimpleName()));
  }

  public int numDependencies() {
    int[] count = {0};
    logService.stream().forEach(e -> count[0]++);
    return count[0];
  }
}
