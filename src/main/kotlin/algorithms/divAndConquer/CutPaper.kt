package algorithms.divAndConquer

import java.io.BufferedReader
import java.io.InputStreamReader


private var blue = 0
private var white = 0

/*
예제
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
 */
fun main() { //백준 2630 색종이 만들기 - 재귀 응용 문제

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr = Array(n) { Array(n) { 0 } }

    for (i in arr.indices) {

        val input = br.readLine().split(" ")

        for (j in input.indices) {
            arr[i][j] = input[j].toInt()
        }
    }

    cutting(0, 0, n - 1, n - 1, arr)
    println("${white}")
    println("${blue}")

}

private fun cutting(y1: Int, x1: Int, y2: Int, x2: Int, arr: Array<Array<Int>>) {
    val temp = arr[y1][x1]
    var needCut = false

    if(x1 == x2 && y1 == y2){
        if (temp == 1) {
            blue++
        } else {
            white++
        }
        return
    }
    for (i in y1..y2) {

        for (j in x1..x2) {
            if (arr[i][j] != temp) {
                needCut = true
                break
            }
        }
    }

    if (needCut) {
        val xHalf = (x1 + x2) / 2
        val yHalf = (y1 + y2) / 2
        cutting(y1, x1, yHalf, xHalf, arr)
        cutting(y1, xHalf + 1, yHalf, x2, arr)
        cutting(yHalf + 1, x1, y2, xHalf, arr)
        cutting(yHalf +1, xHalf + 1, y2, x2, arr)

    } else {
        if (temp == 1) {
            blue++
        } else {
            white++
        }
    }
}


