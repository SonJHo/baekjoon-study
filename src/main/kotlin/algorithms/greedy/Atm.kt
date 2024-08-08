package algorithms.greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.StringTokenizer


fun main() { //백준 11399 - atm 줄서기  ( 그리디 알고리즘 )
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    var list = ArrayList<Client>()

    for (i in 1.. n){
        list.add(Client(i, st.nextToken().toInt()))
    }

    list.sortBy { it.time }

    var totalSum = 0
    var nowSum = 0

    for (client in list) {
        nowSum += client.time
        totalSum += nowSum
    }
    println("${totalSum}")



}

private class Client(val num : Int, val time : Int){

    override fun toString(): String {
        return "Client(num=$num, time=$time)"
    }
}

