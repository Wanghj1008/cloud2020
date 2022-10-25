package spring.LTW;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Component //默认Spring管理启用默认AOP
public class LogMethodInvokeAspect {

    @Pointcut("execution(public * spring.LTW.*.*(..))")
    public void pointCut(){
    }


    @Around("pointCut()")
    public void advise(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        System.out.println(signature+" start..... ");
        pjp.proceed();
        System.out.println(signature+" end......");
    }

}
