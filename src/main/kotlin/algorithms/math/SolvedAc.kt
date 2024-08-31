package algorithms.math

import kotlin.math.min


fun main() {//백준 18110 - 반올림 학습
    // 코틀린 round 메서드를 사용해서 했는데 틀림 > 알아보니 반올림방법에는 오사오입 과 사사오입이 있음
    // 보통 우리가 아는 방법은 사사오입인데  코틀린의 round 는 오사오입임
    // 웃기게도 자바는 사사오입임 그래서 java.lang.Math의 round를 사용했더니 정답처리됨
    val n = readln().toDouble()
    val arr = Array(31) { 0 }
    var sum = 0


    val cut = Math.round(n * 0.15).toInt()
    for (i in 1..n.toInt()) {
        val input = readln().toInt()
        sum += input
        arr[input]++
    }

    var frontSum = 0
    var remain = cut
    for (i in 1..30) {
        val int = arr[i]
        if (int != 0) {
            val count = min(remain, int)
            frontSum += i * count
            remain -= count
        }
        if (remain == 0) {
            break
        }
    }

    var backSum = 0
    remain = cut
    for (i in 30 downTo 1) {
        val int = arr[i]
        if (int != 0) {
            val count = min(remain, int)
            backSum += i * count
            remain -= count
        }
        if (remain == 0) {
            break
        }
    }
    //println("sum = ${sum}")
    //println("frontSum = ${frontSum}")
    //println("backSum = ${backSum}")

    val result = (sum - frontSum - backSum) / (n - (2 * cut))

    println(Math.round(result).toInt())

}

