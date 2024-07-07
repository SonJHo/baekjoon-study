package algorithms.sort

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    //백준 10989 - CountingSort 풀이 O(n)
    // *입력 되는 수의 범위가 제한적일 때 메모리 사용량이 큰 대신 속도가 가장 빠름
    //이문제 에서는 수의 범위는 1부터 10000까지
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val countingArr = Array(10001) { 0 }

    var max = 0
    for (i in 1..n) {
        val input = br.readLine().toInt()
        if( input > max){
            max = input
        }
        countingArr[input]++
    }
    println(printCountingArr(countingArr, max))
    br.close()

}

private fun printCountingArr(countingArr: Array<Int>, max: Int): String {
    val sb = StringBuilder()

    for (i in 1..max) {
        val value = countingArr[i]
        for (j in 1..value) {
            sb.append(i)
            sb.append("\n")
        }
    }
    return sb.toString()
}