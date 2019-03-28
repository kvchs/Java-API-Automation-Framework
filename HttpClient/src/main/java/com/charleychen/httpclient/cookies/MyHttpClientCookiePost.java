package com.charleychen.httpclient.cookies;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyHttpClientCookiePost {
    private String url;
    private ResourceBundle resourceBundle;

    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest() {
        resourceBundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = resourceBundle.getString("test.url");
    }

    @Test
    public void test() throws IOException {
        cookieStore = new BasicCookieStore();
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        String result;
        String uri = resourceBundle.getString("getCookies.uri");
        String testUrl = url + uri;
        HttpGet httpGet = new HttpGet(testUrl);
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        List<Cookie> cookies = cookieStore.getCookies();
        System.out.println(cookies.size());
        System.out.println(cookies.get(0).getName());
        System.out.println(cookies.get(0).getValue());
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name is " + name + ", Cookie value is " + value);
        }
    }


    @Test(dependsOnMethods = {"test"})
    public void testPostMethod() throws IOException {
        String uri = resourceBundle.getString("post.with.cookies");
        String testUrl = url + uri;
//        声名一个携带Cookies信息的Client对象，用例进行方法的执行
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
//        声名一个方法，POST
        HttpPost httpPost = new HttpPost(testUrl);
//        添加参数
        JSONObject param = new JSONObject();
        param.put("name", "charleychen");
        param.put("age", "18");
//        设置请求头信息
        httpPost.setHeader("content-type", "application/json");
//        设置参数信息
        StringEntity stringEntity = new StringEntity(param.toString(), "utf-8");
        httpPost.setEntity(stringEntity);
//        声名一个对象进行响应结果的存储
        String result;
//        执行Post方法
        CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
//        获取响应结果
        int statusCode = response.getStatusLine().getStatusCode();
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
//        将返回的响应结果转换为Json对象
        JSONObject resultJson = new JSONObject(result);
//        判断是否成功
        String success = (String) resultJson.get("success");
        String statusCode0 = (String) resultJson.get("status_code");
        Assert.assertEquals("true", success);
        Assert.assertEquals("50000", statusCode0);
    }
}
