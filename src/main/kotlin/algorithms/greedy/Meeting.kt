package algorithms.greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
 */
fun main() { //백준 1931 - 가능한 한 많은 회의실 배정 ( 그리디 알고리즘 )

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = Array(n) { Array(2) { 0 } }

    for (i in arr.indices) {
        val st = StringTokenizer(br.readLine())
        val fr = st.nextToken().toInt()
        val to = st.nextToken().toInt()

        arr[i][0] = fr
        arr[i][1] = to
    }


    arr.sortBy { it[0] }
    arr.sortBy { it[1] }


    var count = 0
    var end = 0

    for (ints in arr) {
        if(end <= ints[0]){
            end = ints[1]
            count++
        }
    }
    println(count)


}

