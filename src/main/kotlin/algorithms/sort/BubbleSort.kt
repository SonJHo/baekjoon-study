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

fun main(){ //백준 2750 - bubbleSort 풀이 O(n2)
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt() //크기
    val arr = Array(n){0}

    for (i in 0..<n){
        arr[i] = br.readLine().toInt()
    }

    val bubbleSorted = bubbleSort(arr)
    printArr(bubbleSorted)

}

fun printArr(bubbleSorted: Array<Int>) {
    for (i in bubbleSorted) {
        print("$i ")
    }
}

private fun bubbleSort(arr: Array<Int>): Array<Int> {
    if (arr.size < 2){
        return arr
    }

    for( i in arr.size -1  downTo 1){  //4321
        for(j in 0..<i){
            if(arr[j] > arr[j+1] ){
                swap(arr, j, j+1)
            }
        }
    }

    return arr
}

fun swap(arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
