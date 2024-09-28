package algorithms.graph

fun main() {

    val (n, e) = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()

    val arr = Array(n) { Array(n) { "INF" } }


    for (i in 1..e) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        arr[u - 1][v - 1] = w.toString()
    }
    for (i in 1.. n){
        arr[i - 1][i -1] = "0"
    }

    for (ints in arr) {
        for (int in ints) {
            print(String.format("%-4s", int))
        }
        println()
    }


}