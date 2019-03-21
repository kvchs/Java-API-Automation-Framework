package com.charleychen.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod在测试方法之前运行");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod在测试方法之后运行");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass在类运行之前运行");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass在类运行之前运行");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");

    }
}
