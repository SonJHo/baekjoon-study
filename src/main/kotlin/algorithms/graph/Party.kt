package algorithms.graph

import java.util.PriorityQueue

fun main() {// 백준 1238 - 파티

    //처음엔 무식하게 마을의 개수만큼 다익스트라를 돌려서 풀었음
    //근데 다른방법으로 2번의 다익스트라 만으로 풀수 있는것을 알았음
    //x -> 다른 노드 들로의 최단거리 를 구한 후  그래프를 뒤집어 한번 더 실행

    val (n, m, x) = readln().split(" ").map { it.toInt() }
    // 마을 수 , 간선 수 , 파티 마을
    val pathList = Array(n + 1) { ArrayList<Town>() }
    val reversPathList = Array(n + 1) { ArrayList<Town>() }
    for (i in 1..m) {
        val (fr, to, t) = readln().split(" ").map { it.toInt() }
        pathList[fr].add(Town(to, t))
        reversPathList[to].add(Town(fr, t))
    }


    val dijkstra = dijkstra(pathList, n, x)
    val reverseDijkstra = dijkstra(reversPathList, n, x)



    var max = Int.MIN_VALUE
    for (i in 1..n) {
        if(dijkstra[i] + reverseDijkstra[i] > max){
            max = dijkstra[i] + reverseDijkstra[i]
        }
    }

    println(max)
}

private fun dijkstra(pathList: Array<ArrayList<Town>>, n: Int, x: Int): Array<Int> {
    val distanceArr = Array(n + 1) { Int.MAX_VALUE }
    val queue = PriorityQueue<Town>()
    val visited = Array(n + 1) { false }
    distanceArr[x] = 0
    queue.offer(Town(x, 0))
    while (queue.isNotEmpty()) {
        val now = queue.poll()
        visited[now.num] = true

        pathList[now.num].forEach {
            if (!visited[it.num] && distanceArr[it.num] > it.wei + distanceArr[now.num]) {
                distanceArr[it.num] = it.wei + distanceArr[now.num]
                queue.offer(Town(it.num, distanceArr[it.num]))
            }
        }
    }
    return distanceArr
}

private class Town(val num: Int, val wei: Int) : Comparable<Town> {
    override fun compareTo(other: Town): Int {
        return this.wei - other.wei
    }

    override fun toString(): String {
        return "(num=$num, wei=$wei)"
    }

}