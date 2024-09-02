package algorithms.graph


import java.util.Queue
import java.util.ArrayDeque


private lateinit var visit: Array<Array<Boolean>>
private lateinit var arr: Array<Array<String>>
fun main() {//백준 10026 - 적록색약 bfs
    val n = readln().toInt()
    arr = Array(n) { Array(n) { " " } }
    visit = Array(n) { Array(n) { false } }

    for (i in arr.indices) {
        val chars = readln().map { it }
        for (j in arr[0].indices) {
            arr[i][j] = chars[j].toString()
        }
    }

    var count = 0
    for (i in arr.indices) {
        for (j in arr[0].indices) {
            val isArea = bfs(ColorPoint(i, j))
            if (isArea) {
                count++
            }
        }
    }
    print("$count ")

    for (i in arr.indices){
        for (j in arr[0].indices){
            if(arr[i][j] == "G"){
                arr[i][j] = "R"
            }
        }
    }

    count = 0
    visit = Array(n){Array(n){false} }
    for (i in arr.indices) {
        for (j in arr[0].indices) {
            val isArea = bfs(ColorPoint(i, j))
            if (isArea) {
                count++
            }
        }
    }
    println(count)



}

private fun bfs(point: ColorPoint): Boolean {
    val queue: Queue<ColorPoint> = ArrayDeque()
    if (visit[point.y][point.x]) {
        return false
    }

    queue.offer(point)
    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        val y = polled.y
        val x = polled.x
        val color = arr[y][x]

        check(color, ColorPoint(y - 1, x), queue)
        check(color,ColorPoint(y + 1, x), queue)
        check(color,ColorPoint(y, x - 1), queue)
        check(color,ColorPoint(y, x + 1), queue)
    }
    return true
}

private fun check(color : String, point: ColorPoint, queue: Queue<ColorPoint>) {
    val y = point.y
    val x = point.x
    if (x < 0 || y < 0 || y > arr.lastIndex || x > arr[0].lastIndex) {
        return
    }
    if (visit[y][x]) {
        return
    } else {
        if(arr[y][x] == color){
            visit[y][x] = true
            queue.offer(point)

        }
    }
}

private class ColorPoint(val y: Int, val x: Int) {

}