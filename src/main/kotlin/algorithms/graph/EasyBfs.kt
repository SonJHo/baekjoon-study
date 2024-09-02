package algorithms.graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Queue
import java.util.ArrayDeque
import java.util.StringTokenizer

private var n = 0
private var m = 0
private lateinit var visited: Array<Array<Boolean>>
private lateinit var board: Array<Array<Int>>
private lateinit var result: Array<Array<Int>>
fun main() {// 백준 14940 - 쉬운 최단 거리
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    board = Array(n) { Array(m) { 0 } }
    visited = Array(n) { Array(m) { false } }
    result = Array(n) { Array(m) { 0 } }

    var y = 0
    var x = 0
    for (i in board.indices) {
        st = StringTokenizer(br.readLine())
        for (j in board[0].indices) {
            val int = st.nextToken().toInt()
            if (int == 2) {
                y = i
                x = j
            } else if (int == 0) {
                visited[i][j] = true
            }

            board[i][j] = int
        }
    }

    bfs(Point(y, x))
    val sb = StringBuilder()

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (result[i][j] == 0 && !visited[i][j]) {
                result[i][j] = -1
            }
            sb.append("${result[i][j]} ")

        }
        sb.append("\n")

    }
    println(sb)


}

private fun bfs(point: Point) {
    val queue: Queue<Point> = ArrayDeque()
    visited[point.y][point.x] = true
    queue.offer(point)
    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        val y = polled.y
        val x = polled.x

        val count = result[y][x]
        check(count, Point(y - 1, x), queue)
        check(count, Point(y + 1, x), queue)
        check(count, Point(y, x + 1), queue)
        check(count, Point(y, x - 1), queue)
    }
}

private fun check(count: Int, point: Point, queue: Queue<Point>) {
    val y = point.y
    val x = point.x
    if (x < 0 || y < 0 || y >= n || x >= m) {
        return
    }
    if (visited[y][x]) {
        return
    } else {
        visited[y][x] = true
        result[y][x] = count + 1
        queue.offer(point)
    }

}

private class Point(val y: Int, val x: Int) {
}