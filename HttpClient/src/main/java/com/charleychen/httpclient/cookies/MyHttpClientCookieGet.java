package com.charleychen.httpclient.cookies;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyHttpClientCookieGet {

    private String url;
    private ResourceBundle resourceBundle;

    //    用来存储Cookies信息的变量
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
//        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        // 获取Cookie信息新版本的HttpClient获取Cookies
        //使用CloseableHttpClient类实例化httpClient对象
        // refer:https://www.cnblogs.com/ceshi2016/p/7244608.html
//        CookieStore cookieStore = new BasicCookieStore();
//        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
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

    @Test
    public void test2Old() throws IOException {
        String result;
        String uri = resourceBundle.getString("getCookies.uri");
        String testUrl = url + uri;
        HttpGet httpGet = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        CloseableHttpResponse response = client.execute(httpGet);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        CookieStore store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        System.out.println(cookies.size());
        System.out.println(cookies.get(0));
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name is " + name + ", Cookie value is " + value);
        }
    }

    @Test(dependsOnMethods = "test")
    public void testGetWithCookies() throws IOException {
        String uri = resourceBundle.getString("get.with.cookies");
        String testUrl = url + uri;
        HttpGet httpGet = new HttpGet(testUrl);
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode() == 200){
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
            Assert.assertEquals("must visit with cookies info", result);
        }

    }
}
