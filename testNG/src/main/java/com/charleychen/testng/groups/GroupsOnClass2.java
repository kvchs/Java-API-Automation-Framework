package com.charleychen.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu2")
public class GroupsOnClass2 {

    public void test1(){
        System.out.println("GroupsOnClass2 -> test1");
    }

    public void test2(){
        System.out.println("GroupsOnClass2 -> test2");
    }
}