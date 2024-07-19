package algorithms.dynamic

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/*
예제
2
1
3
2
3
 */
fun main() { //백준 2775 - 아파트 거주 인원수 구하기. 다이나믹 프로그래밍
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    for(t in 1.. n){
        val k = br.readLine().toInt()
        val m = br.readLine().toInt()

        val building = Array(k + 1) { Array(m) { 0 } }

        for (j in 0..<m) {
            building[0][j] = j + 1
        }

        for (j in building.indices){
            building[j][0] = 1
        }

        for (i in 1..<building.size){
            for (j in 1..<m){
                building[i][j] = building[i][j-1] + building[i-1][j]
            }
        }
        sb.append(building[building.size-1][building[0].size-1])
        sb.append("\n")
    }
    println(sb)

}

private fun printBuilding(building: Array<Array<Int>>) {
    for (ints in building) {
        for (int in ints) {
            print("${int} ")
        }
        println()
    }
    println()
}