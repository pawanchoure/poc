package com.pawan.choure;


import org.springframework.cache.CacheManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeService {

    private CacheManager cacheManager;

    public Composite getCustomerResponse(Composite key, Response response) {
        System.out.println("Inside getCustomerResponse");
        return null;
    }

    public Composite getComposite(int intKey,String stringKey, Composite composite){
        System.out.println("Inside getComposite");
        return composite;
    }

    public Composite getCompositeCheck(int intKey,String stringKey, Composite composite){
        System.out.println("Inside getCompositeCheck");
        return null;
    }

    public Composite putComposite(Composite composite) {
        System.out.println("Inside putComposite");
        return composite;
    }

    public Composite removeComposite(Composite composite) {
        System.out.println("Inside removeComposite");
        return composite;
    }

    @Loggable
    public List<Integer> getOTCMarkets() {
        System.out.println("Inside putComposite");
        List<Integer> markets=new ArrayList<>(Arrays.asList(1,2,3,3,4));
        return markets;
    }
    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
