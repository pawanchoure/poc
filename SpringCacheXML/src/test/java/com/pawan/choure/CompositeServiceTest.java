package com.pawan.choure;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-test-context.xml"})
public class CompositeServiceTest {

    @Autowired
    private CompositeService compositeService;

    @Autowired
    private CacheManager cacheManager;

    public CompositeService getCompositeService() {
        return compositeService;
    }

    public void setCompositeService(CompositeService compositeService) {
        this.compositeService = compositeService;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Test
    public void testSpringCacheXML() {
        List<Customer> customerList = new ArrayList<>();
        final Customer cust1 = new Customer("Tom", "67-2, Downing Street, NY");
        final Customer cust2 = new Customer("Tom", "67-2, Downing Street, NY");
        customerList.add(cust1);
        customerList.add(cust2);

        Composite composite = new Composite("ABC", customerList, 1);

        List<Customer> customerList2 = new ArrayList<>();
        final Customer cust3 = new Customer("To", "67-2, Downing Street, NY");
        final Customer cust4 = new Customer("Tod", "67-2, Downing Street, NY");

        customerList2.add(cust3);
        customerList2.add(cust4);
        Composite composite2 = new Composite("ABC", customerList, 2);


        List<Customer> customerList3 = new ArrayList<>();
        final Customer cust5 = new Customer("To", "67-2, Downing Street, NY");
        final Customer cust6 = new Customer("Tod", "67-2, Downing Street, NY");

        customerList3.add(cust5);
        customerList3.add(cust6);
        Composite composite3 = new Composite("ABC", customerList, 1);


        List<Customer> customerList4 = new ArrayList<>();
        final Customer cust7 = new Customer("To", "67-2, Downing Street, NY");
        final Customer cust8 = new Customer("Tod", "67-2, Downing Street, NY");

        customerList3.add(cust7);
        customerList3.add(cust8);
        Composite composite4 = new Composite("ABC", customerList, 5);

        List<Composite> compositeList=new ArrayList<>();
        compositeList.add(composite);
        compositeList.add(composite2);
        for(Composite comp:compositeList){
            compositeService.putComposite(comp);
        }

        for(Composite comp:compositeList){
            compositeService.removeComposite(comp);
        }

        compositeService.getComposite(composite.getId(), composite.getPublication(), composite);
        compositeService.getComposite(composite2.getId(), composite2.getPublication(), composite2);
        //This should pick it from Cache
        compositeService.getComposite(composite3.getId(), composite3.getPublication(), composite3);
        System.out.println("Inside customerResponse");

        Composite responsePresent = compositeService.getCompositeCheck(composite3.getId(), composite3.getPublication(), composite3);

        Composite responseMissing = compositeService.getCompositeCheck(composite4.getId(), composite4.getPublication(), composite4);
        ConcurrentHashMap<CacheKey, Composite> compositeConcurrentHashMap = (ConcurrentHashMap<CacheKey, Composite>) cacheManager.getCache("composite").getNativeCache();
    }


    @Test
    public void testMethodwithListReturn() {
//otcMarkets
        compositeService.getOTCMarkets();
        compositeService.clearOTCMarkets();
        compositeService.getOTCMarkets();
        cacheManager.getCache("otcMarkets").evict("getOTCMarkets");
        compositeService.getOTCMarkets();
    }



    @Test
    public void testSpringAOP() {

        compositeService.getOTCMarkets();
    }
}
