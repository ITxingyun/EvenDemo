package com.xingyun.javalib.list;

import java.util.List;
import java.util.UUID;

/**
 * @author chenyiwen2
 */
public class UnsafeList {

	public static void list(List<String> list) {

		System.out.println(list);
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> list.add(UUID.randomUUID().toString().substring(0, 6)), String.valueOf(i)).start();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		System.out.println(list);
	}


}
