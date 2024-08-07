package algorithms.backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private lateinit var arr : Array<Int>
private lateinit var visit : Array<Boolean>

fun main() { //백준 15649 n과 m - dfs

    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    arr = Array(m){0}
    visit = Array(n){false}

    dfs(n, m, 0)


}

private fun dfs(n: Int, m: Int, depth: Int) {
    if(depth == m){
        for (i in arr) {
            print("$i ")
        }
        println()
        return
    }

    for (i in 0..<n){
        if(!visit[i]){
            visit[i] = true
            arr[depth] = i + 1
            dfs(n, m, depth + 1)

            visit[i] = false
        }
    }


}

