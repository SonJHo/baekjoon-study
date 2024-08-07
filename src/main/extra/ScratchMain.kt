import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var arr: Array<Int>

var n = 0
var m = 0

fun main() { //백준 15649 n과 m - dfs

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

