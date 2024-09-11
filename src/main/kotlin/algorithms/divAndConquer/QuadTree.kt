package algorithms.divAndConquer

import java.lang.StringBuilder

private lateinit var arr: Array<Array<Char>>
private lateinit var sb :StringBuilder
fun main() {//백준 1992 - 쿼드 트리

    val n = readln().toInt()
    arr = Array(n) { Array(n) { ' ' } }
    sb = StringBuilder()
    for (i in 0..<n) {
        val input = readln()

        for (j in input.indices) {
            arr[i][j] = input[j]
        }
    }
    compress(0, 0, n)
    println(sb)
}

private fun compress(y: Int, x: Int, n: Int) {


    if (check(y, x, n)) {
        sb.append(arr[y][x])
    } else {
        sb.append("(")

        if (n == 2) {
            for (i in y..<y + n) {
                for (j in x..<x + n) {
                    sb.append(arr[i][j])
                }
            }
            sb.append(")")

            return
        }

        val half = n / 2
        compress(y, x, half)
        compress(y, x + half, half)
        compress(y + half, x, half)
        compress(y + half, x + half, half)
        sb.append(")")
    }
}

private fun check(y: Int, x: Int, n: Int): Boolean {
    val c = arr[y][x]
    for (i in y..<y + n) {
        for (j in x..<x + n) {
            if (arr[i][j] != c) {
                return false
            }
        }
    }
    return true
}

