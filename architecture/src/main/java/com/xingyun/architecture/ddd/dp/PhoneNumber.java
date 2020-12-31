package com.xingyun.architecture.ddd.dp;

import com.xingyun.architecture.ddd.ValidationException;

import java.util.Arrays;

/**
 * 解决数据校验问题，减少样版代码，并减少Test Case
 * 问题：还是要编译时才会报错
 */
public class PhoneNumber {

	private final String number;

	public String getNumber() {
		return number;
	}

	public PhoneNumber(String number) {
		//让隐性的概念显性化
		if (number == null) {
			throw new ValidationException("number不能为空");
		} else if (!isValid(number)) {
			throw new ValidationException("number格式错误");
		}
		this.number = number;
	}

	//让隐性的概念显性化
	public String getAreaCode() {
		for (int i = 0; i < number.length(); i++) {
			String prefix = number.substring(0, i);
			if (isAreaCode(prefix)) {
				return prefix;
			}
		}
		return null;
	}

	private static boolean isAreaCode(String prefix) {
		String[] areas = new String[]{"0571", "021", "010"};
		return Arrays.asList(areas).contains(prefix);
	}

	public static boolean isValid(String number) {
		String pattern = "^0?[1-9]{2,3}-?\\d{8}$";
		return number.matches(pattern);
	}

	@Override
	public String toString() {
		return "PhoneNumber{" +
				"number='" + number + '\'' +
				'}';
	}
}