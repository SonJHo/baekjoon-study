package algorithms.recursion

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.pow
/*
예제
0
1
3
2

 */

fun main() {//백준 4779 - 칸토어 집합 (재귀) 풀이 O(n)

    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val input = br.readLine()
        if(input.isNullOrBlank()){
            break
        }

        val n = input.toInt()
        val size = 3.0.pow(n.toDouble()).toInt()

        val arr = Array(size) { "-" }
        process(arr, 0, arr.lastIndex)

        for (s in arr) {
            sb.append(s)
        }
        sb.append("\n")
    }
    println(sb)
    br.close()

}

fun process(arr: Array<String>, l: Int, h: Int) {
    val size = h - l + 1
    if (size < 3) {
        return
    }
    else {
        val div = size / 3
        process(arr, l, l + div - 1)
        for (i in l + div..<l + div*2){
            arr[i] = " "
        }
        process(arr, l + div*2, h)
    }

}
