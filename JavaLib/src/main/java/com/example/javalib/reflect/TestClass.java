package com.example.javalib.reflect;

public class TestClass {
    private String MSG = "Original";
    private final String FINAL_VALUE = "FINAL";
    private final Integer integer = 5;

    @FieldTypeAnnotation("annotation")
    private String annotation;


    public String getAnnotation() {
        return annotation;
    }

    public String getFinalValue(){
        return FINAL_VALUE;
    }

    public Integer getFinalInteger(){
        return integer;
    }

    private void privateMethod(String head , int tail){
        System.out.print(head + tail);
    }

    public String getMsg(){
        return MSG;
    }
}
