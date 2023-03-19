package com.spring.aop.aspects;

import com.spring.aop.dao.PassengerDaoImpl;
import com.spring.aop.model.Passenger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class CachingAspect {

    @Around("execution(* com.spring.aop.dao.PassengerDaoImpl.getPassenger(..))")
    public void cachePassenger(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        Object[] methodArgs = thisJoinPoint.getArgs();
        Passenger result = (Passenger) thisJoinPoint.proceed();

        int id = (Integer) methodArgs[0];
        if (!PassengerDaoImpl.getPassengerMap().containsKey(id)) {
            PassengerDaoImpl.getPassengerMap().put(id, result);
        }
    }
}
