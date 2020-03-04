package club.mikusun.iadmin.provide.account.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class JpaAspect {
    @Pointcut("execution( public  * club.mikusun.iadmin.provide.account.service.*.*.*(..))")
    public void jpaPointcut(){};

//    @Around("jpaPointcut()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint){
//
//
//    }
}
