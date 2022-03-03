package com.xingyun.javalib.tdd;

import static com.google.common.truth.Truth.assertThat;

import junit.framework.TestCase;

public class CourierTest extends TestCase {

	public void testDeliver() {
		Courier courier = new Courier("小明", "骑摩托车");
		String deliver = courier.deliver("送快递");
		assertThat(deliver).isEqualTo("小明骑摩托车送快递");
	}
}