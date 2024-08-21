package algorithms.dynamic

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() { //백준 1912번 - 연속합

    val n = readln().toInt()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    val dp = Array(n){0}
    dp[0] = arr[0]

    for (i in 1.. dp.lastIndex){

        dp[i] = max(arr[i], dp[i-1] + arr[i])
    }


    println(dp.max())

}