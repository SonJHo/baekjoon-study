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
fun main() { //백준 2750 - InsertionSort 풀이 O(n2)
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = Array(n) { 0 }

    for (i in 0..<n) {
        arr[i] = br.readLine().toInt()
    }

    val sortedArr = insertionSort(arr)
    for (i in sortedArr) {
        println(i)
    }
}

fun insertionSort(arr: Array<Int>): Array<Int> {
    for (i in 1..<arr.size) {
        var j = i
        while (arr[j] < arr[j - 1]) {
            swap(arr, j, j- 1)
            j--
            if(j == 0){
                break
            }
        }
    }
    return arr
}


















