package com.example.basic;

import com.example.service.LogService;
import com.example.service.PlainLogger;
import org.springframework.beans.factory.ObjectProvider;

public class ExampleFour {

  private final ObjectProvider<LogService> logService;

  public ExampleFour(ObjectProvider<LogService> logService) {
    this.logService = logService;
  }

  LogService getLogService() {
    // use PlainLogger as fallback.
    // Note: getIfAvailable wont work for multiple dependencies
//    return logService.getIfAvailable(PlainLogger::new);
    return logService.getIfUnique(PlainLogger::new);
  }

  public void runApps() {
    getLogService().log("some app data with " + getClass().getSimpleName());
  }

  public int numDependencies() {
    int[] count = {0};
    logService.stream().forEach(e -> count[0]++);
    return count[0];
  }
}
