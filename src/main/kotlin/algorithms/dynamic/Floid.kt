package algorithms.dynamic

fun main() {//백준 110404 - 플로이드

    val n = readln().toInt()
    val m = readln().toInt()
    val inf = 100_000_000
    val arr = Array(n) { Array(n) { inf } }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if( arr[a-1][b-1] > c){
            arr[a - 1][b - 1] = c
        }
    }

    for (i in 0..<n) {
        arr[i][i] = 0
    }

    for (i in 0..<n) {
        //i = 거쳐갈 노드
        for (j in 0..<n) {
            if (j == i) {
                continue
            }
            for (k in 0..<n) {
                if (arr[j][k] > arr[j][i] + arr[i][k]) {
                    arr[j][k] = arr[j][i] + arr[i][k]
                }
            }
        }
    }
    for (ints in arr) {
        for (int in ints) {
            if (int >= inf) {
                print("0 ")
            } else {
                print("$int ")
            }
        }
        println()
    }


}