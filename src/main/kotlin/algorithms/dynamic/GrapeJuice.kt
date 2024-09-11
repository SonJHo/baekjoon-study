package algorithms.dynamic

import kotlin.math.max

private lateinit var input: Array<Int>
private lateinit var dp: Array<Int?>
fun main() { //백준 2156 - 포도주 시식
    //조건을 잘 따지자...

    val n = readln().toInt()
    input = Array(10001){0}
    dp = Array(10001){null}


    for (i in 1..n){
        input[i] = readln().toInt()
    }

    dp[0] = 0
    dp[1] = input[1]
    if( n < 2){
        println(input[1])
        return
    }
    dp[2] = input[2] + input[1]



    for (i in 3.. dp.lastIndex){
        juice(i)
    }

    var max  = Int.MIN_VALUE


    for (i in dp) {
        if(i!! > max){
            max = i
        }
    }
    println(max)

}

private fun juice(n: Int): Int {
    if(dp[n] != null){
        return dp[n]!!
    }else{
        dp[n] = max(juice(n-2),input[n-1] + juice(n-3)) + input[n]
    }
    if(dp[n]!!< dp[n-1]!!){
        dp[n] = dp[n-1]
    }
    return dp[n]!!

}
