package com.example.myapplication.Simple4;

import java.util.HashMap;
import java.util.Map;

public class Singleton3 {
    private static Map<String,Object> map = new HashMap<>();
    static {
        map.put("activity",new Singleton3());
    }
    private Singleton3(){

    }
    public static Object getservice(String serviceName){
        return map.get(serviceName);
    }
}
