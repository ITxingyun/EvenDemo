package com.xingyun.thirdlib.mapstruct.simple;

import org.mapstruct.Mapper;

//自动转换
//转换的实体需要get和set方法
@Mapper
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}