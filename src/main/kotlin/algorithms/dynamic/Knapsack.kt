package algorithms.dynamic

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max


var n = 0
var k = 0

private lateinit var dp: Array<Array<Int?>>
private lateinit var items: ArrayList<Item>
fun main() { //백준 12865 - 평범한 배낭
    //다이나믹 프로그래밍은 DP그래프를 잘 설계하는게 중요함
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    k = st.nextToken().toInt()


    items = ArrayList()
    dp = Array(n) { Array(k + 1) { null } }

    for (i in 1..n) {
        val (w, v) = br.readLine().split(" ").map { it.toInt() }
        items.add(Item(w, v))
    }

    val knapsack = knapsack(n - 1, k)
    println(knapsack)

}

fun knapsack(y: Int, x: Int): Int? {
    if(y < 0){
        return 0
    }

    if (dp[y][x] == null) {
        if (items[y].weight > x) {
            dp[y][x] = knapsack(y - 1, x)
        } else {
            dp[y][x] = max(knapsack(y - 1, x)!!, knapsack(y - 1, x - items[y].weight)!! + items[y].price)
        }
    }
    return dp[y][x]
}

private fun printDp() {
    for (ints in dp) {
        for (int in ints) {
            print("${int} ")
        }
        println()
    }
}

private class Item(val weight: Int, val price: Int) {
}