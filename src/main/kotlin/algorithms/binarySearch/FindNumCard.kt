package algorithms.binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder


private lateinit var cards: Array<Int>
fun main() {
    //이분탐색을 실시할 때 찾는값이 중복해서 여러개 있을경우 가장 처음 나오는 인덱르르 찾는것을 lowerBound
    // 가장 마지막 인덱스를 찾는것을 upperBound
    //
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    cards = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    cards.sort()
    val m = br.readLine().toInt()
    val input = br.readLine().split(" ").map { it.toInt() }

    for (i in input.indices) {
        sb.append("${upperBound(input[i]) - lowerBound(input[i])} ")
    }
    println(sb)
}

private fun lowerBound(key: Int): Int {
    var l = 0
    var h = cards.size
    while (l != h) {
        val mid = (l + h) / 2
        if (cards[mid] >= key) {
            h = mid
        } else if (cards[mid] < key) {
            l = mid + 1
        }
    }

    return l

}

private fun upperBound(key: Int): Int {
    var l = 0
    var h = cards.size
    while (l != h) {
        val mid = (l + h) / 2
        if (cards[mid] == key) {
            l = mid + 1
        } else if (cards[mid] < key) {
            l = mid + 1
        } else if (cards[mid] > key) {
            h = mid
        }
    }
    return h
}
