package com.example.baselib.annotation

class AnnotationTest {

    @Retention(AnnotationRetention.RUNTIME)
    @kotlin.annotation.Target(AnnotationTarget.FUNCTION)
    annotation class OnEvent(val value: String)

}