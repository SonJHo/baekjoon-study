package algorithms.stack

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

import java.util.ArrayDeque

fun main() { //백준 17298 오큰수 - 스택 응용
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    val inputArr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val stack = ArrayDeque<Int>()

    stack.push(0)
    for (i in 1..<n) {
        while (stack.isNotEmpty()) {
            val currentIndex = stack.peek()
            if (inputArr[currentIndex] < inputArr[i]) {
                stack.pop()
                inputArr[currentIndex] = inputArr[i]
            } else {
                break
            }
        }
        stack.push(i)
    }

    while (stack.isNotEmpty()) {
        inputArr[stack.pop()] = -1
    }
    for (i in inputArr) {
        sb.append("$i ")
    }
    println(sb)

}