package algorithms.graph.bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayDeque
import java.util.Queue
import java.util.TreeSet

private val queue : Queue<Int> = ArrayDeque()
private lateinit var arr :Array<Int>
private var count = 0
fun main() { //백준 244444 너비 우선 탐색1

    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    arr = Array(n){0}
    val nodeArr = Array(n) { TreeSet<Int>() }
    val visit = Array(n) { false }
    for (i in 1..m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        nodeArr[u - 1].add(v)
        nodeArr[v - 1].add(u)
    }

    bfs(nodeArr,visit, r)

    for (i in arr) {
        sb.append("$i\n")
    }
    println(sb)
}

private fun bfs(nodeArr: Array<TreeSet<Int>>, visit: Array<Boolean>, r: Int) {
    visit[r-1] = true
    arr[r-1] = ++count

    queue.offer(r-1)
    while (queue.isNotEmpty()){
        val polled = queue.poll()
        val set = nodeArr[polled].reversed()

        for (i in set) {
            if(!visit[i-1]){
                visit[i-1] = true
                arr[i-1] = ++count

                queue.offer(i-1)
            }
        }
    }
}
