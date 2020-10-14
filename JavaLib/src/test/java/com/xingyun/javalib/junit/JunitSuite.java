package com.xingyun.javalib.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({JunitTest01.class, JUnitTest.class, JunitTest02.class}) //此处类的配置顺序会影响执行顺序
public class JunitSuite {
    //这个意义何在？ 难道只是简单的把几个类的test一起跑？
    //整个module的test task是通过这种模式来跑的？
}
