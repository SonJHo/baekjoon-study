package algorithms.graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap


private val Nodes =HashMap<Int, TreeSet<Int>>()
private val sb = StringBuilder()
fun main() {//백준 1260 DFS 와 BFS
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }

    for (i in 1.. n){
        Nodes[i] = TreeSet()
    }

    for (i in 1.. m){
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        Nodes[u]!!.add(v)
        Nodes[v]!!.add(u)
    }
    val visit = Array(n){false}

    dfs(r, visit.clone())
    println(sb)
    sb.clear()
    bfs(r , visit.clone())
    println(sb)

}

private fun dfs(r: Int, visit: Array<Boolean>) {
    visit[r-1] = true
    sb.append("$r ")
    val set = Nodes[r]
    if(set!!.isEmpty()){
        return
    }else{
        for (i in set) {
            if(!visit[i-1]){
                dfs(i, visit)
            }
        }
    }


}

private fun bfs(r: Int, visit: Array<Boolean>) {
    val queue : Queue<Int> = ArrayDeque()
    visit[r-1] = true
    sb.append("$r ")
    queue.offer(r)

    while (queue.isNotEmpty()){
        val polled = queue.poll()
        val set = Nodes[polled]
        if( set!!.isNotEmpty()){
            for (i in set) {
                if(!visit[i-1]){
                    visit[i-1] = true
                    sb.append("$i ")
                    queue.offer(i)
                }
            }
        }
    }
}




