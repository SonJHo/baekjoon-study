package algorithms.sort

import java.io.BufferedReader
import java.io.InputStreamReader

/*예제
8
5
2
3
4
1
9
8
6
*/

fun main() { //백준 2750 - selectionSort 풀이 O(n2)
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt() //크기
    val arr = Array(n) { 0 }

    for (i in 0..<n) {
        arr[i] = br.readLine().toInt()
    }

    selectionSort(arr)
    //printArr(arr)
    for (i in arr) {
        println(i)
    }

}

private fun selectionSort(arr: Array<Int>) {

    if( arr.size < 2){
        return
    }

    for (i in 0..<arr.size - 1) {  //크기가 5라면 0..<5
        var min = Int.MAX_VALUE
        var minIndex = -1
        for(j in i..<arr.size){
            if (arr[j] < min){
                min = arr[j]
                minIndex = j
            }
        }

        swap(arr, minIndex, i)
    }

}
