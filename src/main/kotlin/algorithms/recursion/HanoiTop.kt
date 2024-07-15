package algorithms.recursion

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

var count = 0
val sb = StringBuilder()

/*
예제
3
 */
fun main() { //백준 11729 하노이 탑 문제

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    move(n, 1, 3)
    println(count)
    println(sb)
}

private fun move(n: Int, fr: Int, to: Int) {
    if (n > 1) {
        move(n - 1, fr, 6 - fr - to)   //마지막 판을 제외한 나머지를 임시 기둥으로
    }
    sb.append("${fr} ${to} \n")           //가장 큰 판 이동
    count++

    if (n > 1) {
        move(n - 1, 6 - fr - to, to)  //임시 기둥에 있던 판들 목적지로 이동
    }
}


