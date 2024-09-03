package algorithms.recursion

import kotlin.math.pow

private var count = 0L  //이건 숫자를 세기 시작하는 숫자
private lateinit var arr: Array<Array<Int>>
private var R = 0L
private var C = 0L
fun main() {// 백준 1074 - Z
    //정답을 맞추긴 했는데 뭔가 정공법은 아닌것 같음  찝찝.
    //처음엔 크기만 큼 배열생성하고 재귀적으로 숫자를 채우는 방법으로 했는데 입력크기가 너무 커서 시간초과
    //필요한 사분면만 잘라보기로함 -> 어찌어찌 성공
    val (a, r, c) = readln().split(" ").map { it.toInt() }
    // R, C 가 몇사분면에 있을까

    R = r.toLong()
    C = c.toLong()
    var n = 2.0.pow(a).toLong()

    while (n > 4) {
        val amount = n * n
        val half = n / 2 - 1

        if (R <= half) {
            if (C <= half) {//1사분면
            } else {
                count += amount / 2 / 2
            }

        } else {
            if (C <= half) {//3사분면
                count += amount / 2
            } else {//4사분면
                count += (amount / 2 + amount) / 2
            }
        }

        if (R > half) { //좌표 압축
            R = R - half - 1
        }
        if (C > half) {
            C = C - half - 1
        }

        n = half + 1
    }

    arr = Array(n.toInt()) { Array(n.toInt()) { 0 } }
    recursion(n.toInt(), 0, 0)

    println(arr[R.toInt()][C.toInt()])

}

private fun recursion(n: Int, y: Int, x: Int) {
    if (n == 2) {
        for (i in y..y + 1) {
            for (j in x..x + 1) {
                arr[i][j] = count.toInt()
                count ++
            }
        }
        return

    } else if (n > 2) {
        val size = n / 2
        recursion(n / 2, y, x)
        recursion(n / 2, y, x + size)
        recursion(n / 2, y + size, x)
        recursion(n / 2, y + size, x + size)
    }
}
