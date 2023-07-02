package com.coditas.learn.aop.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Data
public class Student {
  private String name;
  private Integer assignmentsSubmitted;

  public Student() {
    name = null;
    assignmentsSubmitted = 0;
  }

  public Integer submitAssignment(Integer count) throws Exception {
    assignmentsSubmitted = assignmentsSubmitted + count;
//    Random rd = new Random();
//    if (rd.nextBoolean()) {
//      throw new Exception();
//    }
    return assignmentsSubmitted;
  }
}
