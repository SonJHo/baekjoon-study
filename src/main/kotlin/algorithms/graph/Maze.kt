package algorithms.graph

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


private lateinit var maze: Array<Array<Int>>
private lateinit var visited: Array<Array<Boolean>>
fun main() { //백준 2179 - 미로 탐색
    //처음에 dfs로 접근했으나 최단 경로 찾는게 불가능  -> bfs 로 접근해야함
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    maze = Array(n) { Array(m) { 0 } }
    visited = Array(n) { Array(m) { false } }

    for (i in 0..<n) {
        val input = br.readLine().toCharArray()
        for (j in 0..< m){
            maze[i][j] = input[j].toString().toInt()
        }
    }

    println(bfs(0, 0))

}

private fun bfs(i1: Int, i2: Int): Int {

    val queue: Queue<Node> = ArrayDeque()
    queue.offer(Node(i1, i2, 1))

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        val x = node.x
        val y = node.y

        if ((x >= 0 && x <= maze[0].lastIndex) && (y >= 0 && y <= maze.lastIndex)) {
            if (!visited[y][x] && maze[y][x] != 0) {
                visited[y][x] = true
                maze[y][x] = node.ds
                queue.offer(Node(y - 1, x, node.ds + 1))
                queue.offer(Node(y, x + 1, node.ds + 1))
                queue.offer(Node(y, x - 1, node.ds + 1))
                queue.offer(Node(y + 1, x, node.ds + 1))
            }
        }
    }
    return maze[maze.lastIndex][maze[0].lastIndex]
}

private class Node(val y: Int, val x: Int, val ds: Int) {
}




