package algorithms.graph

import java.util.PriorityQueue

fun main() {//백준 1916 - 최소비용 구하기 (다익스트라)


    val n = readln().toInt()
    val m = readln().toInt()
    val distance = Array(n + 1) { Int.MAX_VALUE }
    val list = Array(n + 1) { ArrayList<Station>() }

    for (i in 1..m) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        list[u].add(Station(v, w))
    }

    val (fr, to) = readln().split(" ").map { it.toInt() }

    val queue = PriorityQueue<Station>()
    distance[fr] = 0
    queue.offer(Station(fr, 0))

    val visited = Array(n + 1) { false }
    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        val now = polled.num

        if (!visited[now]) {
            visited[now] = true
            list[now].forEach {
                if (!visited[it.num] && distance[it.num] > distance[now] + it.wei) {
                    distance[it.num] = distance[now] + it.wei
                    queue.offer(Station(it.num, distance[it.num]))
                }
            }
        }
    }

    println(distance[to])


}

private class Station(val num: Int, val wei: Int) : Comparable<Station> {
    override fun compareTo(other: Station): Int {
        return this.wei - other.wei
    }

    override fun toString(): String {
        return "Station(num=$num)"
    }
}