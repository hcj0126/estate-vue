package com.test;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestDemo {

    @Test
    public void test01() {
        Map<String,String> map = new HashMap<>();
        map.put("1","张三");
        map.put("2","里斯");
        map.put("3","王五");
        map.put("4","马六");
        map.put("5","化工");
        System.out.println(map);
        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(map));
        System.out.println(json);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        JsonElement je = gson.toJsonTree(gson.toJson(map));
        String s = gson.toJson(map);
        System.out.println(je);
        System.out.println(s);
    }
}
