package com.charleychen.httpclient.testcase;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestOne {

    @Test
    public void test1(){
        String result = getResult();
    }

    private String getResult() {
        HttpPost post = new HttpPost();
        JSONObject param = new JSONObject();
//        设置  键值对
        param.put("", "");
//        设置头信息
        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), "UTF-8");
        post.setEntity(entity);
//        设置cookies
        String result;
//        HttpResponse response = Test
        return "";
    }
}
