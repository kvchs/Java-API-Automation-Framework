package com.charleychen.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 什么时候回用异常测试：
     * 在我们期望结果为一个异常的时候
     * 比如：我们传入类某些不合法的参数，程序抛出了异常
     * 也就是说我们的预期就是发生这个异常
     */

    @Test(expectedExceptions = RuntimeException.class)
    public void testFail(){
        System.out.println("异常测试 RuntimeException");
        throw new RuntimeException();
    }

}
