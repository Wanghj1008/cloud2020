package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyAspect {
    @Pointcut("execution(public * proxy.FoodServiceImpl.makeChicken())")
    public void divPointCut() {
        System.out.println("11");
    }

    @Before("divPointCut()")
    public void beforeNotify() {
        System.out.println("----===>> @Before 我是前置通知");
    }

    @After("divPointCut()")
    public void afterNotify() {
        System.out.println("----===>> @After  我是后置通知");
    }

    @AfterReturning("divPointCut()")
    public void afterReturningNotify() {
        System.out.println("----===>> @AfterReturning 我是最终通知");
    }

    @AfterThrowing("divPointCut()")
    public void afterThrowingNotify() {
        System.out.println("----===>> @AfterThrowing 我是异常通知");
    }

    @Around("divPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retVal =new Object();
        try {
            System.out.println("----===>> @Around 环绕通知之前 AAA");
            retVal = proceedingJoinPoint.proceed();
            System.out.println("----===>> @Around 环绕通知之后 BBB");
        } catch (Throwable throwable) {
            System.out.println("----===>> @Around 环绕通知之后 CCC");
            throw throwable;
        }
        return retVal;
    }
}