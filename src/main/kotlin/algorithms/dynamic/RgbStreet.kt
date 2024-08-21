package algorithms.dynamic

import java.awt.Color
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min


private const val red = 0
private const val green = 1
private const val blue = 2

private lateinit var arr : Array<Array<Int>>
private lateinit var dp : Array<Array<Int>>
fun main() { //백준 1149 - RGB 거리
   val br = BufferedReader(InputStreamReader(System.`in`))
    val n = readln().toInt()
    arr = Array(n) { Array(3) { 0 } }

    dp = Array(n) { Array(3) { 0 } }

    for (i in 0..< n){
        val st = StringTokenizer(br.readLine())
        arr[i][red] = st.nextToken().toInt()
        arr[i][green] = st.nextToken().toInt()
        arr[i][blue] = st.nextToken().toInt()

        if(i == 0){
            dp[i][red] = arr[i][red]
            dp[i][green] = arr[i][green]
            dp[i][blue] = arr[i][blue]
        }
    }

    println(min(cost(n-1, red), min(cost(n-1, green), cost(n-1, blue))))
}

private fun cost(n: Int, color: Int): Int {

    if(dp[n][color] == 0){
        if(color == red){
            dp[n][color] =  min(cost(n-1, green), cost(n-1, blue)) + arr[n][color]
        }else if(color == green){
            dp[n][color] = min(cost(n-1, red), cost(n-1, blue)) + arr[n][color]
        }else{
            dp[n][color] = min(cost(n-1, red), cost(n-1, green)) + arr[n][color]
        }
    }
    return dp[n][color]


}
