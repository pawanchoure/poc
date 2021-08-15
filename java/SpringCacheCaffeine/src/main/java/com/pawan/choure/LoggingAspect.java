package com.pawan.choure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoggingAspect {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Around("execution(* *(..)) && @annotation(com.pawan.choure.Loggable)")
    public Object logMethods(ProceedingJoinPoint jp) throws Throwable {
        String methodName = jp.getSignature().getName();
        logMethodInvocationAndParameters(jp);

        long startTime = new Date().getTime();
        Object result = jp.proceed(jp.getArgs());
        long endTime = new Date().getTime();

        System.out.println("\nExecution time: " + (endTime - startTime) + "ms");
        System.out.println("<- " + methodName + " returns \n" + gson.toJson(result) + "\n");

        return result;
    }

    private void logMethodInvocationAndParameters(ProceedingJoinPoint jp) {
        String[] argNames = ((MethodSignature) jp.getSignature()).getParameterNames();
        Object[] values = jp.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }

        System.out.println("-> method " + jp.getSignature().getName() + " invocation");
        if (!params.isEmpty()) System.out.println(gson.toJson(params));
    }

  /*  @Pointcut("within@com.pawan.choure.Loggable *)")
    public void loggable(){

    }


    @Before("loggable()")
    public void beforeMethodStatistics(JoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        if (null != args && args.length > 0) {
            for (Object arg : args) {
                if (arg instanceof BaseRequest) {
                    ((BaseRequest) arg).setStartTimeInMillis(Calendar.getInstance().getTimeInMillis());
                    break;
                }
            }
        }
    }

    @After("loggable()")
    public void afterMethodStatistics(JoinPoint jp) {
        Object[] args = jp.getArgs();
        if (null != args && args.length > 0) {
            for (Object arg : args) {
                if (arg instanceof BaseRequest) {
                    StatisticsUtils.calculateStatistics(jp, arg, StatisticsMapEnum.ASPECT_LOGGER_STATISTICS_MAP);
                    break;
                }
            }
        }
    }*/
}
