package com.xingyun.javalib.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 单元测试JUnit
 */
public class JUnitTest {

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    //需要静态，无参数
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    //需要静态，无参数
    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Test
    public void test01() {
        System.out.println("test");
    }

    //timeout的单位为毫秒，超过这个时间没有执行完毕，就fail
    @Test(timeout = 1000)
    public void test02() {
        System.out.println("test02");
    }

    //异常测试，没有抛出expected的异常，就fail
    @Test(expected = NullPointerException.class)
    public void test03() {
        System.out.println("test03");
        throw new NullPointerException("null");
    }
}
