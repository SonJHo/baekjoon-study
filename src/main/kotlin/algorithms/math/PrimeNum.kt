package algorithms.math

import java.lang.StringBuilder

fun main() {//백준 1929 - 소수 구하기
    //n과 m사이 의 소수를 모두 구하는 방법
    //에라토스테네스의 체
    val (n, m) = readln().split(" ").map { it.toInt() }

    val sb = StringBuilder()
    val arr = Array(m + 1) { true }

    arr[0] = false
    arr[1] = false

    for (i in 2..m) {

        if (arr[i]) {
            for (j in 2..m) {
                val index = i * j
                if (index > m) {
                    break
                }
                arr[index] = false
            }
        }

    }

    for (i in n..m) {
        if (arr[i]) {
            sb.append("$i\n")
        }
    }
    println(sb)


}