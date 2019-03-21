package com.charleychen.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu3")
public class GroupsOnClass3 {

    public void test1(){
        System.out.println("GroupsOnClass3 -> test1");
    }

    public void test2(){
        System.out.println("GroupsOnClass3 -> test2");
    }
}
