package algorithms.recursion

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/*
1
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
 */

private var isChanged = false
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (u in 1.. t){

        var st = StringTokenizer(br.readLine())

        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        val array = Array(n) { Array(m) { 0 } }
        var result = 0

        for (i in 1..k) {

            st = StringTokenizer(br.readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            array[y][x] = 1
        }

        for (y in array.indices) {
            for (x in array[0].indices) {
                if (array[y][x] == 2) {
                    continue
                }

                search(y, x, array)

                if (isChanged) {
                    result++
                    isChanged = false
                }
            }
        }

        println(result)
        isChanged =false
    }
}

private fun search(y: Int, x: Int, array: Array<Array<Int>>) {

    if( y < 0 || y >array.size-1){
        return
    }
    if( x < 0 || x >array[0].size-1){
        return
    }
    if (array[y][x] != 1) {
        return
    }
    array[y][x] = 2
    isChanged = true
    search(y - 1, x, array)
    search(y + 1, x, array)
    search(y, x + 1, array)
    search(y, x - 1, array)
}


