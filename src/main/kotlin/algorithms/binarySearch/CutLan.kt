package algorithms.binarySearch

fun main() {// 백준 1654 - 랜선 자르기

    val (k, n) = readln().split(" ").map { it.toLong() }

    var max = Long.MIN_VALUE
    val arr = ArrayList<Long>()
    for (i in 0..<k) {

        val input = readln().toLong()
        if (input > max) {
            max = input
        }
        arr.add(input)
    }

    max++

    var min = 0L
    var mid = 0L
    while (min < max){

        println("------------")
        println("min = ${min}")
        println("max = ${max}")
        mid = (min + max) / 2
        println("mid = ${mid}")

        var count = 0L

        for (l in arr) {
            count += l /mid
        }
        println("count = ${count}")

        if(count < n){
            println("max를 mid로 변경")
            max = mid
        }else{
            println("min을 mid + 1로 변경")

            min = mid + 1
        }
    }

    println(min -1)


}

