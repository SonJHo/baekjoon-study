package algorithms.math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/*
이중 반복문 으로 접근 했으나 시간 초과
-> 어떠한 정수 A와 B에 대해 A+B를 M으로 나눈 나머지는 A를 M으로 나눈 나머지와 B를 M으로 나눈 나머지를
더한것을 다시 M으로 나누면 결과가 같음

즉
(A+B)%M == ((A%M) + (B % M)) % M  이 성립
(A-B)%M == ((A%M) - (B % M)) % M  음수도 성립
모듈러 연산
 */

fun main() { //백준 10986 나머지 합 문제
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()


    val rest = HashMap<Int, Int>()
    val restArr = Array(1000) { 0 }

    val arr = Array(n) { 0 }
    st = StringTokenizer(br.readLine())
    var sum = 0L
    for (i in arr.indices) {
        sum += st.nextToken().toLong()
        arr[i] = (sum % m).toInt()
    }

    var count = 0L
    for (i in arr.indices) {
        count+= restArr[arr[i]]

        if(arr[i] == 0){
            count++
        }
        restArr[arr[i]]++
    }
    println(count)
}

