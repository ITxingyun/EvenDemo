package com.xingyun.javalib.list;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenyiwen2
 */
@RunWith(Parameterized.class)
public class UnsafeListTest {

	private int input;
	private int expected;

	public UnsafeListTest(int input, int expected) {
		this.input = input;
		this.expected = expected;
	}


	@Test
	public void arrayList() {
		UnsafeList.list(new ArrayList<>());
	}

	@Test
	public void copyOnWriteArrayList() {
		UnsafeList.list(new CopyOnWriteArrayList<>());
	}


	@Parameterized.Parameters(name = "{index}: fib({0})={1}")
	public static Iterable  primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
		});
	}
}