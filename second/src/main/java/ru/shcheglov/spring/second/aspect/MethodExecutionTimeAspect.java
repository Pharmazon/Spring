package ru.shcheglov.spring.second.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 21.01.2019
 */

@Aspect
@Component
public class MethodExecutionTimeAspect {

    private static final Logger LOGGER = LogManager.getLogger(MethodExecutionTimeAspect.class);

    @Pointcut("execution(* ru.shcheglov.spring.second..*.*(..))")
    private void getName() {
    }

    @Around("getName()")
    public Object monitor(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final Long startTime = System.nanoTime();
        final Object object = proceedingJoinPoint.proceed();
        final Long finishTime = System.nanoTime();
        LOGGER.info((finishTime - startTime) + " ms. - Method execution time");
        return object;
    }

}
