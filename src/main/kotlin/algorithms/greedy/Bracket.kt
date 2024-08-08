package algorithms.greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {//백준 1541 괄호 최솟값  ( 그리디 알고리즘 )
    val br = BufferedReader(InputStreamReader(System.`in`))

    val str = br.readLine()
    val parts = str.split("-")

    var totalSum = 0

    for (i in parts.indices) {
        val sum = parts[i].split("+").sumOf { it.toInt() }

        if (i == 0) {
            totalSum += sum
        } else {
            totalSum -= sum
        }
    }

    println(totalSum)
}
