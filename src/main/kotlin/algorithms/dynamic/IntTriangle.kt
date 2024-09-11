package algorithms.dynamic

import java.util.StringTokenizer
import kotlin.math.max


private lateinit var dp: Array<ArrayList<Int?>>
private lateinit var inputArr: Array<ArrayList<Int?>>
fun main() { //백준 1932 - 정수 삼각형
    val n = readln().toInt()
    inputArr = Array(n) { ArrayList() }
    for (i in inputArr.indices) {
        val st = StringTokenizer(readln())
        while (st.hasMoreTokens()) {
            inputArr[i].add(st.nextToken().toInt())
        }
    }
    dp = Array(n){ ArrayList() }  //dp 초기화
    for (i in 0..<n) {
        for (j in inputArr[i].indices) {
            dp[i].add(null)
        }
    }
    dp[0][0] = inputArr[0][0]
    for (i in dp[n - 1].indices) {
        func(n - 1, i)
    }


    var max = Int.MIN_VALUE
    for (i in dp[n-1].indices){  //최댓값 탐색
        if(dp[n-1][i]!! > max){
            max = dp[n-1][i]!!
        }
    }
    println(max)
}

private fun func(y: Int, x: Int): Int {
    if (dp[y][x] != null) {
        return dp[y][x]!!
    }
    if (x == 0) {
        dp[y][x] = func(y - 1, x) + inputArr[y][x]!!
    } else if (x == dp[y].lastIndex) {
        dp[y][x] = func(y - 1, x - 1) + inputArr[y][x]!!
    }else{
        dp[y][x] = max(func(y-1, x-1), func(y-1, x)) + inputArr[y][x]!!
    }
    return dp[y][x]!!
}
