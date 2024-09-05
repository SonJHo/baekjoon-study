package algorithms.binarySearch

import kotlin.math.max


private lateinit var trees : List<Long>
fun main() { //백준 2805 - 나무 자르기  (이분 탐색)
    val (n, m) = readln().split(" ").map { it.toInt() }

    trees = readln().split(" ").map { it.toLong() }
    val max = trees.max()

    search( max, m)


}

private fun search( h: Long, m: Int) {


    var high = h
    var low = 0L

    var mid = 0L



    while (low < high) {
        mid = (low + high) / 2
        var sum = 0L
        for (tree in trees) {
            sum += max(0, tree - mid)
        }

        if(sum >= m){
            low = mid + 1
        }else{
            high = mid
        }
    }

    println(low-1)
}