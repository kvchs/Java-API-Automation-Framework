package com.charleychen.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu1")
public class GroupsOnClass1 {

    public void test1(){
        System.out.println("GroupsOnClass1 -> test1");
    }

    public void test2(){
        System.out.println("GroupsOnClass1 -> test2");
    }
}