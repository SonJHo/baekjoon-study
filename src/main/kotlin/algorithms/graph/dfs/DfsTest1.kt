package algorithms.graph.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.TreeSet

private lateinit var arr :Array<Int>
private var count = 0
fun main() { //백준 24479 깊이 우선 탐색1
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val nodeArr = Array(n){TreeSet<Int>()}
    val visit = Array(n){false}
    val sb = StringBuilder()
    arr = Array(n){0}

    for (i in 1.. m){
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        nodeArr[u-1].add(v)
        nodeArr[v-1].add(u)
    }

    dfs(nodeArr, visit, r)

    for (i in arr) {
        sb.append(i)
        sb.append("\n")
    }

    println(sb)

}
private fun dfs(nodeArr: Array<TreeSet<Int>>, visit: Array<Boolean>, fr: Int) {
    if( !visit[fr-1]){
        arr[fr-1] = ++count
    }

    visit[fr-1] = true
    val set = nodeArr[fr - 1]
    if(set.isEmpty()){
        return
    }
    for (i in set) {
        if(!visit[i-1]){
            dfs(nodeArr, visit, i)
        }
    }

}
