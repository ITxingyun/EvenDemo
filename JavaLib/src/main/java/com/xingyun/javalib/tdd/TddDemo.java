package com.xingyun.javalib.tdd;

public class TddDemo {

    /**
     * 如果遇到数字为3的倍数，打印“Fizz”，5的倍数用“Buzz”代替，既是3的倍数又是5的倍数打印“FizzBuzz
     * 其他情况打印数字本身
     */
    public static String countOff(Integer count) {
        String result;
        if (isMultiple(count, 15)) {
            result = "FizzBuzz";
        } else if (isMultiple(count, 3)) {
            result = "Fizz";
        } else if (isMultiple(count, 5)) {
            result = "Buzz";
        } else {
            result = count.toString();
        }
        return result;
    }

    private static boolean isMultiple(Integer divisor, Integer dividend) {
        return divisor % dividend == 0;
    }

}
