package algorithms.graph

import java.util.ArrayDeque
import java.util.Queue

private lateinit var map: HashMap<Int, Int>
fun main() { //백준 16928 - 뱀과 사다리 게임


    val (n, m) = readln().split(" ").map { it.toInt() }
    map = HashMap()
    val visit = Array(100) { false }
    for (i in 1..n + m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        map[u] = v
    }
    bfs(Number(1, 0), visit)


}

private fun bfs(number: Number, visit: Array<Boolean>) {

    val queue: Queue<Number> = ArrayDeque()

    queue.offer(number)
    while (queue.isNotEmpty()) {
        var polled = queue.poll()
        if (visit[polled.num - 1]) {
            continue
        } else {
            visit[polled.num - 1] = true
        }

        if (polled.num >= 100) {
            println(polled.count)
            return
        }
        if (map.containsKey(polled.num)) {
            polled = Number(map[polled.num]!!, polled.count)
        }

        for (i in 1..6) {
            queue.offer(Number(polled.num + i, polled.count + 1))
        }
    }
}

private class Number(val num: Int, var count: Int) {
    override fun toString(): String {
        return "$num"
    }
}