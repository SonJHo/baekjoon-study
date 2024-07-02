package algorithms.recursion

import java.lang.StringBuilder
import java.util.Scanner

// input = 3n
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val arr = Array(n) {
        Array(n) { " " }
    }

    writeStar(n, 0, 0, arr)
    println(printArr(arr))
    sc.close()
}

private fun printArr(arr: Array<Array<String>>) : String {
    val sb = StringBuilder()  //시간 초과 해결 위한 가변 String
    for (iner in arr) {
        for (str in iner) {
            sb.append(str)
        }
        sb.append("\n")
    }
    return sb.toString()

}

private fun writeStar(n: Int, x1: Int, x2: Int, arr: Array<Array<String>>) {  //크기, 시작점 좌표
    val y1 = x1 + n-1
    val y2 = x2 + n-1 //마지막 점 좌표

    if (n == 3) {
        for (i in x1..x1 + 2) {
            for (j in x2..x2 + 2) {
                arr[i][j] = "*"
            }
        }
        arr[x1 + 1][x2 + 1] = " "
    } else {
        val part = n / 3
        val emptyPoint1 = x1 + part
        val emptyPoint2 = x2 + part

        for (i in x1..<y1 step part) {
            for (j in x2..<y2 step part) {

                if (i == emptyPoint1 && j == emptyPoint2) {
                    continue
                }
                writeStar(part, i, j, arr)
            }

        }

    }

}