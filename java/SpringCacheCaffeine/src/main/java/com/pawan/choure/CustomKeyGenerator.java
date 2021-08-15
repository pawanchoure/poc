package com.pawan.choure;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;

import java.lang.reflect.Method;

public class CustomKeyGenerator implements KeyGenerator {

    public Object generate(Object target, Method method, Object... params) {
        return generateKey(params);
    }

    public static Object generateKey(Object... params) {
        if (params.length == 0) {
            return SimpleKey.EMPTY;
        } else {
            Integer intValue = null;
            String stringValue = null;
            for(int i=0;i<params.length;i++){
                if(params[i].getClass()==Integer.class){
                    intValue= (Integer) params[i];
                }else if(params[i].getClass()==String.class){
                    stringValue= (String) params[i];
                }
            }
            if(intValue==null && stringValue==null){
              if(Composite.class.equals(params[0].getClass())){
                  Composite composite=(Composite)params[0];
                  return new CacheKey(composite.getId(),composite.getPublication());
              }
            }
            return new CacheKey(intValue,stringValue);
        }
    }
}
