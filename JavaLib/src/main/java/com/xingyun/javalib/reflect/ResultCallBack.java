package com.xingyun.javalib.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ResultCallBack<T> {



    private Class<?> analysisClassInfo(Object object) {
        Type type = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)type).getActualTypeArguments();
        return (Class<?>) params[0];
    }

}
