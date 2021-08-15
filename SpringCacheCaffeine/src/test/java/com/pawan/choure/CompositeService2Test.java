package com.pawan.choure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-test-context.xml"})
public class CompositeService2Test {

    @Autowired
    private CompositeService2 compositeService;

    @Autowired
    private CacheManager cacheManagerSimple;

    public CompositeService2 getCompositeService() {
        return compositeService;
    }

    public void setCompositeService(CompositeService2 compositeService) {
        this.compositeService = compositeService;
    }

    public CacheManager getCacheManagerSimple() {
        return cacheManagerSimple;
    }

    public void setCacheManagerSimple(CacheManager cacheManagerSimple) {
        this.cacheManagerSimple = cacheManagerSimple;
    }

    @Test
    public void testMethodwithListReturn() {

        compositeService.getOTCMarkets();
        compositeService.getOTCMarkets();
        // cacheManager.getCache("otcMarkets").evict("getOTCMarkets");
        compositeService.clearOTCMarkets();
        compositeService.getOTCMarkets();

    }
}
