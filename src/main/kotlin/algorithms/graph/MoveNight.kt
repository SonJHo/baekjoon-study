package algorithms.graph

import java.util.Queue
import java.util.ArrayDeque


private lateinit var arr: Array<Array<Int>>
private lateinit var visit: Array<Array<Boolean>>
fun main() {

    val t = readln().toInt()

    for (j in 1.. t){
        val i = readln().toInt()
        val (y1, x1) = readln().split(" ").map { it.toInt() }
        val (y2, x2) = readln().split(" ").map { it.toInt() }
        arr = Array(i) { Array(i) { 0 } }
        visit = Array(i) { Array(i) { false } }
        visit[y1][x1] = true
        bfs(Night(y1, x1))

        println(arr[y2][x2])
    }

}

private fun bfs(night: Night) {//백준 7562  - 나이트의 이동
    val queue: Queue<Night> = ArrayDeque()
    queue.offer(night)

    val xArr = arrayOf(-2, -2, 2, 2, -1, -1, 1, 1)
    val yArr = arrayOf(-1, 1, -1, 1, 2, -2, 2, -2)

    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        val y = polled.y
        val x = polled.x

        for (i in xArr.indices) {
            check(arr[y][x], y + yArr[i], x + xArr[i], queue)
        }

    }
}

private fun check(count: Int, y: Int, x: Int, queue: Queue<Night>) {
    if (y < 0 || x < 0 || y > arr.lastIndex || x > arr.lastIndex) {
        return
    }
    if (visit[y][x]) {
        return
    }else{
        visit[y][x] = true
        queue.offer(Night(y, x))
        arr[y][x] = count + 1
    }

}

private class Night(val y: Int, val x: Int) {

}