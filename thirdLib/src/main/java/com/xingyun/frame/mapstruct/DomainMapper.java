package com.xingyun.frame.mapstruct;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder)
public interface DomainMapper extends IMapper {
	DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

	@Mapping(source = "modelName", target = "doMainName")
	@Mapping(source = "modelCount", target = "count")
	Domain modelToDomain(Model car);
}
