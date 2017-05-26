package sample.service.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chibana on 2017/05/26.
 */
@Aspect
@Component
public class ValidationInterceptor {

    @Autowired
    Validator validator;

    @Before("execution(* sample.service.ValidationDemoService.*(..))")
    public void validateArgs(JoinPoint joinPoint) {

        Method m = ((MethodSignature)joinPoint.getSignature()).getMethod();
        Class<?>[] parameterTypes = m.getParameterTypes();
        Annotation[][] argsAnnos = m.getParameterAnnotations();
        Object[] args = joinPoint.getArgs();
        Set<ConstraintViolation<?>> violations = new HashSet<ConstraintViolation<?>>();

        for (int i = 0; i < m.getParameterCount(); i ++) {
            for (Annotation anno : argsAnnos[i]) {
                if (Valid.class.equals(anno.annotationType())) {
                    Class parameterType = m.getParameterTypes()[i];
                    violations.addAll(validator.validate(args[i]));
                }
            }
        }
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
