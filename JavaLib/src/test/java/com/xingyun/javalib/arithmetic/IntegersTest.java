package com.xingyun.javalib.arithmetic;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class IntegersTest {

	@Test
	public void test_printInteger() {
		assertThat(Integers.printInteger("1011", "10")).isEqualTo("101");
	}
}