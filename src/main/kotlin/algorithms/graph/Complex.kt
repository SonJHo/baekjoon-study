package algorithms.graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.collections.ArrayList

private var count = 0
fun main() { //백준 2667 단지 번호 붙이기
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val visited = Array(n) { Array(n) { false } }
    val arr = ArrayList<Array<Char>>()

    for (i in 1..n) {
        arr.add(br.readLine().map { it }.toTypedArray())
    }
    val resultList = ArrayList<Int>()

    for (i in arr.indices) {
        for (j in arr[0].indices) {
            dfs(visited, arr, i, j)
            if (count != 0) {
                resultList.add(count)
            }
            count = 0
        }
    }
    resultList.sort()
    sb.append("${resultList.size}\n")
    for (mass1 in resultList) {
        sb.append("$mass1\n")
    }
    println(sb)
}

private fun dfs(visited: Array<Array<Boolean>>, arr: java.util.ArrayList<Array<Char>>, l: Int, c: Int) {
    if (l < 0 || l > arr.lastIndex) {
        return
    }
    if (c < 0 || c > arr.lastIndex) {
        return
    }
    if (arr[l][c] == '0') {
        return
    }
    if (arr[l][c] == '1' && !visited[l][c]) {
        visited[l][c] = true
        count++
        dfs(visited, arr, l - 1, c)
        dfs(visited, arr, l, c - 1)
        dfs(visited, arr, l + 1, c)
        dfs(visited, arr, l, c + 1)
    }
}




