package algorithms.divAndConquer


private var count_1 = 0
private var count_0 = 0
private var count_negative1 = 0
private lateinit var input: Array<Array<Int>?>
fun main() { //백준 1780 - 종이의 개수

    val n = readln().toInt()
    input = Array(n) { null }

    for (i in input.indices) {
        input[i] = readln().split(" ").map { it.toInt() }.toTypedArray()
    }


    div(0, 0, n)
    println( count_negative1)
    println(count_0)
    println(count_1)
}

private fun div(y: Int, x: Int, n: Int) {
    if (!paperCheck(y, x, n)) {
        val newSize = n / 3
        for (i in 0.. 2){
            for (j in 0..2){
                div(y + i * newSize, x + j* newSize, newSize)
            }
        }
    }
}

private fun paperCheck(y: Int, x: Int, n: Int): Boolean {
    val num = input[y]!![x]

    for (i in y..<y + n) {
        for (j in x..<x + n) {
            if (num != input[i]!![j]) {
                return false
            }
        }
    }

    if (num == 1) {
        count_1++
    } else if (num == 0) {
        count_0++
    } else {
        count_negative1++
    }
    return true
}
