package algorithms.dynamic

import kotlin.math.max



private  lateinit var dp : Array<Int?>
private lateinit var stairs: Array<Int>
fun main() { //백준 2579 - 계단 오르기
    //무조건 들러야 하는 곳은 find를 태울 필요가 없다.

    val n = readln().toInt()

    stairs = Array(n +1){0}
    dp = Array(n +1){null}


    for (i in 1.. n){
        stairs[i] = readln().toInt()
    }

    dp[0] = stairs[0]
    dp[1] = stairs[1]

    println(find(n))

}

private fun find(step: Int) : Int{
    if(step == 2){
        dp[step] = dp[1]!! + stairs[2]
    }
    if(dp[step] == null){
        dp[step] =  max(find(step-3) + stairs[step-1], find(step-2) ) + stairs[step]
    }

    return dp[step]!!
}

