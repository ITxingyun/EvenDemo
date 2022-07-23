package com.xingyun.javalib.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Integers {

	/**
	 * 题目：输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。
	 * 例如，输入的二进制字符串分别是"11"和"10"，则输出"101"。
	 */
	public static String printInteger(String intString1, String intString2) {
		String result = null;


		int j = 0;
		int l1 = intString1.length();
		int l2 = intString2.length();

		int[] int1 = new int[l1];
		int[] int2 = new int[l2];

		for (int i = 0; i < l1; i++) {
			int1[i] = Integer.parseInt(String.valueOf(intString1.charAt(l1 - i - 1)));
		}
		for (int i = 0; i < l2; i++) {
			int2[i] = Integer.parseInt(String.valueOf(intString1.charAt(l2 - i - 1)));
		}

		if (l1 > l2) {
			for (int i = 0; i < l2; i++) {
				
			}
		}

		return result;
	}



}
