package com.xingyun.evendemo.view.recyclerview.adapter

interface People

data class Student(var name: String, var role: String): People

data class Teacher(var name: String, var subject: String): People