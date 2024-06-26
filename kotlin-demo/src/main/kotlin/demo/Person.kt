package com.crh.generate.demo

import com.luckyframework.httpclient.core.Request

open class Person(var name: String, var age: Int)

class Student(name: String, age: Int, var no: Int, var score: Int) : Person(name, age)

data class User(val name: String, val age: Int)

fun main() {

    val student = Student("张三", 18, 1001, 90)
    println("姓名：${student.name}")
    println("年龄：${student.age}")
    println("学号：${student.no}")
    println("成绩：${student.score}")

    val user = User("李四", 20)
    val (name, age) = user
    print("姓名：$name, 年龄：$age\n")
    println(user.copy(age = 21))
    request()

}

fun request() {
    val request: Request = Request
        .get("http://www.baidu.com")
        .setUserInfo("jack:pass123456")
        .setRef("Lucky")
        .addQueryParameter("keyword", "百度 43");
    println(request.uri)
}