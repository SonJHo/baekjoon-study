package algorithms.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private lateinit var arr: Array<Int>

private var n = 0
private var m = 0

fun main() { //백준 15650 n과m(2) - dfs

    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    arr = Array(m) { 0 }

    dfs(1, 0)


}

private fun dfs(at: Int, depth: Int) {
    if (depth == m) {
        for (i in arr) {
            print("$i ")
        }
        println()
        return
    }

    for (i in at..n) {
        arr[depth] = i
        dfs(i + 1, depth + 1)
    }


}

