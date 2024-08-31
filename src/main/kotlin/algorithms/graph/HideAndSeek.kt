package algorithms.graph

import java.util.Queue
import java.util.ArrayDeque
import kotlin.math.abs


private lateinit var visited: Array<Int>
fun main() {

    visited = Array(100001) { 0 }

    val (n, k) = readln().split(" ").map { it.toInt() }


    if (k > n) {
        bfs(n, k)
    } else if (k == n) {
        println(0)
    } else {
        println(abs(k - n))
    }
}

private fun bfs(n: Int, k: Int) { //백준 1697 - 숨바꼭질
    val queue: Queue<Int> = ArrayDeque()
    visited[n] = 1
    queue.offer(n)

    val bound = k - n + 5
    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled == k) {
            println(visited[polled] - 1)
            return
        } else {
            if(polled + 1 <= 100000){
                if (visited[polled + 1] == 0) {
                    queue.offer(polled + 1)
                    visited[polled + 1] = visited[polled] + 1
                }
            }
            if( polled != 0){
                if (visited[polled- 1] == 0) {
                    queue.offer(polled - 1)
                    visited[polled - 1] = visited[polled] + 1
                }
            }

            if(polled * 2 <= 100000){
                if (visited[polled * 2] == 0) {
                    if (polled * 2 < bound + k) {
                        queue.offer(polled * 2)
                        visited[polled * 2] = visited[polled] + 1

                    }
                }
            }
        }
    }
}
