package algorithms.graph

import java.lang.StringBuilder
import java.util.PriorityQueue

private lateinit var lists: Array<ArrayList<MyNodeV1>>
fun main() { //백준 9370 - Destination
    //다익스트라 응용인데 어떤 경로를 거쳐가는 문제
    //구간별로 쪼개서 다익스트라를 적용함
    //이 외에 구간 비용을 두배씩늘리고 특정구간은 -1을 하여 홀수 짝수인지를 보고 푸는 방법도 있음
    val T = readln().toInt()

    val sb = StringBuilder()
    repeat(T){

        val (n, m, t) = readln().split(" ").map { it.toInt() }
        // 교차로, 도로 , 목적지 개수
        val (s, g, h) = readln().split(" ").map { it.toInt() }
        // s 출발지

        lists = Array(n + 1) { ArrayList<MyNodeV1>() }
        repeat(m) {
            val (a, b, d) = readln().split(" ").map { it.toInt() }
            //a, b, 상에 d의 길이 도록가 있음
            lists[a].add(MyNodeV1(b, d))
            lists[b].add(MyNodeV1(a, d))
        }

        val arr = ArrayList<Int>()
        repeat(t) {
            arr.add(readln().toInt())
        }
        arr.sort()

        val sArr = dijkstra(s, n)
        val gArr = dijkstra(g, n) //3
        val hArr = dijkstra(h, n) //1
        for (i in arr) {
            val cost = sArr[i]
            val compareVal1 = sArr[g] + gArr[h] + hArr[i]
            val compareVal2 = sArr[h] + hArr[g] + gArr[i]

            if(cost == Int.MAX_VALUE){
                continue
            }
            if(cost == compareVal1 || cost == compareVal2){
                sb.append("$i ")
            }
        }
        sb.append("\n")
    }
    println(sb)

}

private fun dijkstra(fr: Int, to: Int): Array<Int> {
    val visited = Array(lists.size) { false }
    val queue = PriorityQueue<MyNodeV1>()
    val dis = Array(lists.size) {Int.MAX_VALUE}
    dis[fr] = 0
    queue.offer(MyNodeV1(fr, 0))
    while (queue.isNotEmpty()) {
        val nowNode = queue.poll()
        visited[nowNode.num] = true
        lists[nowNode.num].forEach {
            if(!visited[it.num]){
                if(dis[it.num] > nowNode.w + it.w){
                    dis[it.num] = nowNode.w + it.w
                    queue.offer(MyNodeV1(it.num, dis[it.num]))
                }
            }
        }
    }
    return dis
}
private class MyNodeV1(val num: Int, val w: Int) : Comparable<MyNodeV1> {
    override fun toString(): String {
        return "MyNode(num=$num, w=$w)"
    }

    override fun compareTo(other: MyNodeV1): Int {
        return this.w - other.w
    }
}

