package com.xingyun.thirdlib.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DomainMapper {
	DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

	@Mapping(source = "modelName", target = "doMainName")
	@Mapping(source = "modelCount", target = "count")
	Domain modelToDomain(Model car);
}
