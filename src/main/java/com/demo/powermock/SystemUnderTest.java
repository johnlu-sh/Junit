package com.demo.powermock;

import java.util.ArrayList;
import java.util.List;

interface Dependency {
  List<Integer> retrieveAllStatus();
}

public class SystemUnderTest {
  private Dependency dependency;

  public int methodUsingAnArrayListConstructor() {
    List list = new ArrayList();
    return list.size();
  }

  public int methodCallingAStaticMethod() {
    List<Integer> stats = dependency.retrieveAllStatus();
    long sum = 0;
    for (int stat: stats) {
      sum += stat;
    }
    return UtilityClass.staticMethod(sum);
  }

  private long privateMethodUnderTest() {
    List<Integer> stats = dependency.retrieveAllStatus();
    long sum = 0;
    for (int stat : stats)
      sum += stat;
    return sum;
  }
}
