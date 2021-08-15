package com.pawan.choure;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeService2 {
    private CacheManager cacheManager;

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

   // @Cacheable(cacheNames="otcMarkets", cacheManager="cacheManagerSimple")
    public List<Integer> getOTCMarkets() {


        System.out.println("Inside getOTCMarkets");
        List<Integer> markets=new ArrayList<>(Arrays.asList(1,2,3,3,4));
        return markets;
    }
   // @Cacheable(cacheNames="otcMarkets", cacheManager="cacheManagerSimple")
    public void clearOTCMarkets() {
        System.out.println("Inside clearOTCMarkets");
        //cacheManager.getCache("otcMarkets").clear();

    }

}
