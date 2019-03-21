package com.charleychen.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){

        System.out.println("name: " + name + " ==== "+ age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] data = new Object[][]{
                {"aaa",10},
                {"bbb",20},
                {"ccc",30}
        };
        return data;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age){
        System.out.println("name: " + name + " ==== "+ age);

    }

    @Test(dataProvider = "methodData",dependsOnMethods = "test1")
    public void test2(String name, int age){
        System.out.println("name: " + name + " ==== "+ age);

    }

    @DataProvider(name = "methodData")
    public Object[][] data(Method method){
        Object[][] data = null;
        if (method.getName().equals("test1")){
            data = new Object[][]{
                    {"aaa",10},
                    {"bbb",20},
                    {"ccc",30}
            };
        }else if (method.getName().equals("test2")){
            data = new Object[][]{
                    {"ddd",40},
                    {"eee",50},
                    {"fff",60}
            };
        }
        return data;
    }

}
