package com.coditas.learn.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

  @Before("execution(public * com.coditas.learn.aop.entity.Student.submitAssignment(..))")
  public void logBeforeV1(JoinPoint joinPoint)
  {
    System.out.println("StudentAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
  }

  @After("execution(public * com.coditas.learn.aop.entity.Student.submitAssignment(..))")
  public void logAfterV1(JoinPoint joinPoint)
  {
    Object[] args = joinPoint.getArgs();
    System.out.println("StudentAspect.logAfterV1() After : " + joinPoint.getSignature().getName());
    System.out.println("Attempted to submit "+ args[0] + " assignments");
  }

  @AfterReturning("execution(public * com.coditas.learn.aop.entity.Student.submitAssignment(..))")
  public void logAfterV2(JoinPoint joinPoint)
  {
    Object[] args = joinPoint.getArgs();
    System.out.println("StudentAspect.logAfterV2() AfterReturning : " + joinPoint.getSignature().getName());
    System.out.println("Successfully submitted "+ args[0] + " assignments");
  }

  @AfterThrowing("execution(public * com.coditas.learn.aop.entity.Student.submitAssignment(..))")
  public void logAfterV3(JoinPoint joinPoint)
  {
    Object[] args = joinPoint.getArgs();
    System.out.println("StudentAspect.logAfterV3() AfterThrowing : " + joinPoint.getSignature().getName());
    System.out.println("Failed to submit "+ args[0] + " assignments");
  }

  // comment out around when you want to use others
  @Around("execution(public * com.coditas.learn.aop.entity.Student.submitAssignment(..))")
  public Object logAround(ProceedingJoinPoint joinPoint) {
    //Before code
    Object[] args = joinPoint.getArgs();
    System.out.println("StudentAspect.logAround() : " + joinPoint.getSignature().getName());
    System.out.println(args[0]+ " Start of around");

    //You can tweak the arg values and pass the updated values to join Point
    args[0] = (Integer)args[0] * 2;

    //call join point
    Object res = null;
    try {
      res = joinPoint.proceed(args);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }

    //After
    System.out.println("End of Around");
    return (Integer)res + 1;
  }
}
