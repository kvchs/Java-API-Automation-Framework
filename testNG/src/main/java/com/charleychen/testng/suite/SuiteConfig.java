package com.charleychen.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite运行中");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite运行中");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest执行");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest执行");
    }
}
