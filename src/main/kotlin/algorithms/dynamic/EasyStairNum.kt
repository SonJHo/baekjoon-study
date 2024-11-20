package algorithms.dynamic

private const val mod = 1_000_000_000L
fun main() {// 백준 10844 - 쉬운 계단수
    //  처음에 아이디어 내는게 쉽지않았음.
    // 길이가 n이면서 마지막 숫자가 i 인 계단수는
    // (길이가 n-1이면서 마지막숫자가 i + 1 ) + (길이가 n-1이면서 마지막 숫자가 i-1인수)
    // 0, 9에 대해선 따로 생각 필요
    val n = readln().toInt()
    val dp: Array<Array<Long?>> = Array(n + 1) { Array(10) { null } }

    for (i in 1..9) {
        dp[1][i] = 1
    }
    dp[1][0] = 0

    for (i in dp[0].indices) {
        process(n, i, dp)
    }

    val result = dp[n]

    var sum = 0L
    for (i in result) {
        sum += i!! % mod
    }
    println(sum % mod)
}

private fun process(n: Int, i: Int, dp: Array<Array<Long?>>): Long {
    if (dp[n][i] == null) {
        var temp = 0L
        temp = if (i == 0) {
            process(n - 1, 1, dp) % mod

        } else if (i == 9) {
            process(n - 1, i - 1, dp) % mod
        } else {

            (process(n - 1, i - 1, dp) % mod + process(n - 1, i + 1, dp) % mod) % mod
        }

        dp[n][i] = temp
    }
    return dp[n][i]!!
}
