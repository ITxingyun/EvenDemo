package com.xingyun.architecture.ddd;

import com.xingyun.architecture.ddd.dp.Address;
import com.xingyun.architecture.ddd.dp.ExchangeRate;
import com.xingyun.architecture.ddd.dp.Money;
import com.xingyun.architecture.ddd.dp.Name;
import com.xingyun.architecture.ddd.dp.PhoneNumber;

/***
 * DDD demo
 * Domain Primitive {@link PhoneNumber}
 *
 */
public class DDD_Demo {

	public static void main(String[] args) {
		//Domain Primitive
		domainPrimitive();
	}

	/**
	 * Domain Primitive
	 * 参考：https://mp.weixin.qq.com/s/kpXklmidsidZEiHNw57QAQ
	 *
	 * 三原则：
	 * 1、让隐性的概念显性化
	 * 2、让隐性的上下文显性化
	 * 3、封装多对象行为
	 */
	private static void domainPrimitive() {
		dp_1();
		dp_2();
		dp_3();
	}


	/**
	 * Domain Primitive
	 * 让隐性的概念显性化
	 * {@link PhoneNumber}
	 */
	private static void dp_1() {
		System.out.println("-----------------------------------------------");
		System.out.println("Domain Primitive 第一原则：让隐性的概念显性化");

		UserRepository userRepository = new UserRepository();
		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(userRepository);
		User user = registrationService.register(new Name(""), new PhoneNumber("021-12345678"), new Address("add"));
		System.out.println(user.toString());
		System.out.println("AreaCode：" + user.getPhoneNumber().getAreaCode());

		System.out.println("-----------------------------------------------\n\n\n");
	}


	/**
	 * Domain Primitive
	 * 让隐性的上下文显性化
	 * {@link Money}
	 */
	private static void dp_2() {
		System.out.println("-----------------------------------------------");



		System.out.println("-----------------------------------------------\n\n\n");
	}

	/**
	 * Domain Primitive
	 * 封装多对象行为
	 * {@link ExchangeRate}
	 */
	private static void dp_3() {
		System.out.println("-----------------------------------------------");



		System.out.println("-----------------------------------------------\n\n\n");
	}

}
