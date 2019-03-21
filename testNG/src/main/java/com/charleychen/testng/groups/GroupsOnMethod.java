package com.charleychen.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "group1")
    public void test1(){
        System.out.println("group1的测试方法1");
    }

    @Test(groups = "group1")
    public void test2(){
        System.out.println("group1的测试方法2");
    }

    @Test(groups = "group2")
    public void test3(){
        System.out.println("group2的测试方法1");
    }

    @Test(groups = "group2")
    public void test4(){
        System.out.println("group2的测试方法2");
    }

    @BeforeGroups("group1")
    public void beforeGroups(){
        System.out.println("组group1运行前运行");
    }

    @AfterGroups("group2")
    public void afterGroups(){
        System.out.println("组group2运行后运行");
    }
}
