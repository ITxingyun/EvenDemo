package com.xingyun.thirdlib.mapstruct;


import org.junit.Test;

public class DomainMapperTest {

	@Test
	public void toDomain() {
		Model model = new Model("name", 5);
		Domain domain = DomainMapper.INSTANCE.modelToDomain(model);
		System.out.println(domain.toString());

	}
}