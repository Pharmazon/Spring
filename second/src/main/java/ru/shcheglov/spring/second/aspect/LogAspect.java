package ru.shcheglov.spring.second.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 20.01.2019
 */

@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LogManager.getLogger(LogAspect.class);

    @Pointcut("execution(* ru.shcheglov.spring.second..*.*(..))")
    private void getName() {
    }

    @Before("getName()")
    public void logBefore(final JoinPoint joinPoint) {
        LOGGER.info(joinPoint);
    }

}
