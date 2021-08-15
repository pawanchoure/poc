package com.pawan.choure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodCacheService {

    public List<Integer> getOTCMarkets() {
        System.out.println("Inside putComposite");
        List<Integer> markets=new ArrayList<>(Arrays.asList(1,2,3,3,4));
        return markets;
    }

    public void clearOTCMarkets() {

    }
}
