package com.tyb1222.aspect;

import com.tyb1222.anno.UserAnno;
import com.tyb1222.service.CacheService;
import com.tyb1222.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class UserAspect {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private LogService logService;

//    @Around("execution(* com.tyb1222.service.impl.*.*(..))")
    @Around("@annotation(userAnno)")
    public Object doAround(ProceedingJoinPoint pjp,UserAnno userAnno) throws Throwable {

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        System.out.println("aspect method is :"+method.getName());
        UserAnno anno = method.getAnnotation(UserAnno.class);
        Method declaredMethod = pjp.getTarget().getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
        UserAnno aa = declaredMethod.getAnnotation(UserAnno.class);
        UserAnno annotation = method.getAnnotation(UserAnno.class);
//        String id = getValue(userAnno.cacheKey(),pjp);
//        System.out.println("UserAnno cacheKey is "+ userAnno.cacheKey());
//        System.out.println("UserAnno cacheName is "+ userAnno.cacheName());
//        System.out.println("UserAnno loggable is "+ userAnno.loggable());
//        System.out.println("method before");
//        Object result = pjp.proceed();
//        System.out.println("method after");
//        return result;

        String key =  userAnno.cacheKey();
        String userId = getValue(key,pjp);
        String CACHE_KEY = userAnno.cacheName();
        Object obj = cacheService.get(userId, CACHE_KEY);
        if (null != obj) {
            return obj.toString();
        }
        Object result = null;
        try {
            result  = pjp.proceed();
        } catch (Exception ex) {
            if (userAnno.loggable()){
                logService.error("get user error" + ex);
            }
        }
        if (userAnno.loggable()) {
            logService.info("get userName from db success");
        }
        cacheService.put(userId,result,CACHE_KEY);
        return result;
    }

    private String getValue(String key,ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        Object [] args = proceedingJoinPoint.getArgs();
        Method method = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod();
        Method declaredMethod = proceedingJoinPoint.getTarget().getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
        String [] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(declaredMethod);
        return SpelParser.getValue(key,parameterNames,args);
    }


}
