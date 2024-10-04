package algorithms.graph

import java.lang.StringBuilder
import java.util.PriorityQueue

fun main() { //백준 1753 - 최단 경로
    // 시작지점이 주어지고 시작지점으로 부터 모드 노드 까지의 최단 거리를 계산 - 다익스트라

    val (n, e) = readln().split(" ").map { it.toInt() }
    val start = readln().toInt()

    val distance =Array(n + 1){Int.MAX_VALUE}
    val arr = Array(n + 1) { PriorityQueue<MyNode>() }
    for (i in 1.. e){
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        arr[u].offer(MyNode(v, w))
    }


    distance[start] = 0
    val queue = PriorityQueue<MyNode>()
    queue.offer(MyNode(start, 0))


    val visited = Array(n + 1){false}
    while (queue.isNotEmpty()){
        val nowNode = queue.poll()
        visited[nowNode.num] = true

        for (nodes in arr[nowNode.num]) {

            if(!visited[nodes.num]){
                if(distance[nowNode.num] + nodes.w < distance[nodes.num]){
                    distance[nodes.num] = distance[nowNode.num] + nodes.w
                    queue.offer(MyNode(nodes.num, distance[nodes.num]))
                }
            }
        }


    }

    val sb = StringBuilder()
    for (i in 1.. distance.lastIndex){
        if( distance[i] == Int.MAX_VALUE){
            sb.append("INF\n")
        }else{
            sb.append("${distance[i]}\n")
        }
    }
    println(sb)
}

private class MyNode (val num : Int, val w : Int) : Comparable<MyNode>{
    override fun toString(): String {
        return "Node(num=$num, w=$w)"
    }

    override fun compareTo(other: MyNode): Int {
        return this.w - other.w
    }
}