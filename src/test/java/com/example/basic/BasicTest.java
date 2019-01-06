package com.example.basic;

import com.example.service.JsonLogger;
import com.example.service.PlainLogger;
import org.junit.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class BasicTest {

  /**
   * Throws Unsatisfied dependency expressed through field 'logService';
   * nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException:
   * No qualifying bean of type 'com.example.beans.LogService' available: expected at least 1 bean which qualifies as autowire candidate.
   * Dependency annotations: @org.springframework.beans.factory.annotation.Autowired(required=true)
   */
  @Test(expected = UnsatisfiedDependencyException.class)
  public void testExampleOneMissingBean() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleOne.class);
      context.refresh();

      ExampleOne example = context.getBean(ExampleOne.class);
      example.runApps();
    }
  }

  @Test
  public void testExampleTwoWithNoLogger() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleTwo.class);
      context.refresh();

      ExampleTwo example = context.getBean(ExampleTwo.class);
      assertEquals(0, example.numDependencies());
      example.runApps();
    }
  }

  @Test
  public void testExampleTwoWithOneLogger() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleTwo.class, PlainLogger.class);
      context.refresh();

      ExampleTwo example = context.getBean(ExampleTwo.class);
      assertEquals(1, example.numDependencies());
      example.runApps();
    }
  }

  @Test(expected = NoUniqueBeanDefinitionException.class)
  public void testExampleTwoWithMultipleLoggers() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleTwo.class, PlainLogger.class, JsonLogger.class);
      context.refresh();

      ExampleTwo example = context.getBean(ExampleTwo.class);
      example.runApps();
    }
  }

  @Test
  public void testExampleThreeWithMultipleLoggers() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleThree.class, PlainLogger.class, JsonLogger.class);
      context.refresh();

      ExampleThree example = context.getBean(ExampleThree.class);
      assertEquals(2, example.numDependencies());
      example.runApps();
    }
  }

  @Test
  public void testExampleThreeWithNoLoggers() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleThree.class);
      context.refresh();

      ExampleThree example = context.getBean(ExampleThree.class);
      assertEquals(0, example.numDependencies());
      example.runApps();
    }
  }

  @Test
  public void testExampleFourWithNoLoggers() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleFour.class);
      context.refresh();

      ExampleFour example = context.getBean(ExampleFour.class);
      assertEquals(0, example.numDependencies());
      example.runApps();
    }
  }

  @Test
  public void testExampleFourWithOneLogger() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleFour.class, JsonLogger.class);
      context.refresh();

      ExampleFour example = context.getBean(ExampleFour.class);
      assertEquals(1, example.numDependencies());
      example.runApps();
    }
  }

  @Test
  public void testExampleFourWithMultipleLoggers() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleFour.class, PlainLogger.class, JsonLogger.class);
      context.refresh();

      ExampleFour example = context.getBean(ExampleFour.class);
      assertEquals(2, example.numDependencies());
      example.runApps();
    }
  }

  @Test
  public void testExampleFiveWithNoLoggers() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleFive.class);
      context.refresh();

      ExampleFive example = context.getBean(ExampleFive.class);
      assertEquals(0, example.numDependencies());
      example.runApps();
    }
  }

  @Test
  public void testExampleFiveWithOneLogger() {
    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
      context.register(ExampleFive.class, JsonLogger.class);
      context.refresh();

      ExampleFive example = context.getBean(ExampleFive.class);
      example.runApps();
    }
  }
}
