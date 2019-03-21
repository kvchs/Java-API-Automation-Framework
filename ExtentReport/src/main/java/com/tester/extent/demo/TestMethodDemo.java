package com.tester.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(3, 3);
    }

    @Test
    public void test3(){
        Reporter.log("log in org.testng.Reporter");
        throw new RuntimeException("test3 error");
    }


}
