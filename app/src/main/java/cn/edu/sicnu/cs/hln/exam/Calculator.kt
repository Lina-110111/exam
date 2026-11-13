package cn.edu.sicnu.cs.hln.exam

// 这是一个专门用来做计算的类
class Calculator {
    // 加法
    fun add(a: Double, b: Double): Double = a + b
    // 减法
    fun subtract(a: Double, b: Double): Double = a - b
    // 乘法
    fun multiply(a: Double, b: Double): Double = a * b
    // 除法
    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) return 0.0
        return a / b
    }
}