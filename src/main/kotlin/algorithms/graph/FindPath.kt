package algorithms.graph

import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.collections.ArrayList


private lateinit var arr: Array<Array<Int>>
private lateinit var nearNodes: Array<ArrayList<Int>>
fun main() { //백준 11403 -경로 찾기
    //dfs로 풀었는데 알아보니 플로이드 와샬 알고리즘 으로도 풀수있음 학습요망

    val n = readln().toInt()

    arr = Array(n) { Array(n) { 0 } }

    nearNodes = Array(n + 1) { ArrayList<Int>() }
    for (i in 0..<n) {
        val st = StringTokenizer(readln())
        for (j in 0..<n) {
            arr[i][j] = st.nextToken().toInt()
            if (arr[i][j] == 1) {
                nearNodes[i + 1].add(j + 1)
            }
        }
    }

    for (i in arr.indices) {
        for (j in arr[0].indices) {
            val visit = Array(n + 1) { false }
            check(i + 1, visit)

            if(visit[j + 1]){
                arr[i][j] = 1
            }else{
                arr[i][j] = 0
            }
        }
    }

    val sb = StringBuilder()
    for (ints in arr) {
        for (int in ints) {
            sb.append("$int ")
        }
        sb.append("\n")
    }


    println(sb)
}

private fun check(fr: Int, visit: Array<Boolean>) {
    for (i in nearNodes[fr]) {
        if (!visit[i]) {
            visit[i] = true
            check(i,  visit)
        }
    }
}


