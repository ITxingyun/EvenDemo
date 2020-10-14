package com.xingyun.javalib.tdd;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TddDemoTest {
    @Test
    public void should_return_fizz_when_count_is_the_multiples_of_3() {
        assertThat(TddDemo.countOff(3)).isEqualTo("Fizz");
        assertThat(TddDemo.countOff(6)).isEqualTo("Fizz");
        assertThat(TddDemo.countOff(96)).isEqualTo("Fizz");
    }

    @Test
    public void should_return_buzz_when_count_is_the_multiples_of_5() {
        assertThat(TddDemo.countOff(5)).isEqualTo("Buzz");
        assertThat(TddDemo.countOff(25)).isEqualTo("Buzz");
        assertThat(TddDemo.countOff(100)).isEqualTo("Buzz");
    }

    @Test
    public void should_return_fizzbuzz_when_count_is_the_multiples_of_3_and_5() {
        assertThat(TddDemo.countOff(15)).isEqualTo("FizzBuzz");
        assertThat(TddDemo.countOff(45)).isEqualTo("FizzBuzz");
        assertThat(TddDemo.countOff(90)).isEqualTo("FizzBuzz");
    }

    @Test
    public void should_return_count_itself_when_count_is_not_the_multiples_of_3_or_5() {
        assertThat(TddDemo.countOff(2)).isEqualTo("2");
        assertThat(TddDemo.countOff(7)).isEqualTo("7");
        assertThat(TddDemo.countOff(91)).isEqualTo("91");
    }
}