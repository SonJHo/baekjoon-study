package algorithms.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer


private var n = 0
private var m = 0
private lateinit var arr: Array<Int>

private val sb = StringBuilder()

fun main() {//백준 15651 n과m(3) - dfs

    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    arr = Array(m) { 0 }

    bfs(0)

    println(sb)

}

private fun bfs(depth: Int) {

    if(depth == m){
        for (i in arr) {
            sb.append("$i ")
        }
        sb.append("\n")
        return
    }

    for (i in 1.. n){

        arr[depth] = i
        bfs(depth + 1)

    }

}
