package com.example.basic;

import com.example.service.LogService;
import org.springframework.beans.factory.ObjectProvider;

public class ExampleThree {

  private final ObjectProvider<LogService> logService;

  public ExampleThree(ObjectProvider<LogService> logService) {
    this.logService = logService;
  }

  public void runApps() {
    logService.stream().forEach(e -> e.log("some app data with " + getClass().getSimpleName()));
  }

  public int numDependencies() {
    int count = 0;
    for (LogService ls : logService) {
      count++;
    }
    return count;
  }
}
