package algorithms.graph

import java.util.Queue
import java.util.ArrayDeque
import java.util.StringTokenizer


private lateinit var queue: Queue<Tomato>
private lateinit var input: Array<Array<Int>>
private lateinit var visit: Array<Array<Boolean>>
fun main() {// 백준 7576 - 토마토 (1)
    val (m, n) = readln().split(" ").map { it.toInt() }

    visit = Array(n) { Array(m) { false } }
    input = Array(n) { Array(m) { 0 } }
    queue = ArrayDeque()

    var isAllRipen = true
    for (i in input.indices) {
        val st = StringTokenizer(readln())
        for (j in input[0].indices) {
            val int = st.nextToken().toInt()
            if (int == 1) {
                visit[i][j] = true
                queue.offer(Tomato(i, j))
            } else if (int == -1) {
                visit[i][j] = true
            }else{
                isAllRipen = false
            }
            input[i][j] = int
        }
    }

    if(isAllRipen){
        println(0)
    }else{
        bfs()
        var maxDate = 0
        for ( i in input.indices){
            for (j in input[0].indices){
                if(input[i][j] == 0 && !visit[i][j]){
                    println(-1)
                    return
                }
                if(input[i][j] > maxDate){
                    maxDate = input[i][j]
                }
            }
        }
        println(maxDate - 1)
    }
}

private fun bfs() {

    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        val y = polled.y
        val x = polled.x
        val date = input[y][x]

        check(date, y - 1, x)
        check(date, y + 1, x)
        check(date, y, x - 1)
        check(date, y, x + 1)
    }


}

private fun check(date: Int, y: Int, x: Int) {

    if (x < 0 || y < 0 || y > input.lastIndex || x > input[0].lastIndex) {
        return
    }
    if (visit[y][x]) {
        return
    } else {
        visit[y][x] = true
        input[y][x] = date + 1
        queue.offer(Tomato(y, x))
    }

}

private class Tomato(val y: Int, val x: Int) {

}