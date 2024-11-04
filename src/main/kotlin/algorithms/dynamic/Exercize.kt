package algorithms.dynamic

import kotlin.collections.ArrayList

fun main() {// 백준 1956 - 운동 ( 플로이드 와샬)

    val (v, e) = readln().split(" ").map{it.toInt()}


    val dis = Array(v){Array(v){100_000_000} }

    for (i in 0..<v){
        dis[i][i] = 0
    }
    val list = Array(v + 1){ArrayList<MyPoint>()}
    repeat(e){
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        list[a].add(MyPoint(a, b, c))
        dis[a - 1][b - 1] = c
    }


    for (i in dis.indices){ //거쳐갈 노드

        for (j in dis.indices){
            if(j == i){
                continue
            }

            for (k in dis.indices){
                if(dis[j][i] + dis[i][k] < dis[j][k]){
                    dis[j][k] = dis[j][i] + dis[i][k]
                }

            }
        }
    }

    var min = Int.MAX_VALUE

    for (i in 0..< v){
        for (j in 0..< v){
            if(j == i){
                continue
            }
            val cost = dis[i][j] + dis[j][i]

            if( cost >= 100_000_000){
                continue
            }
            if(cost < min){
                min = cost
            }

        }
    }
    if(min == Int.MAX_VALUE){
        println(-1)
    }else{
        println(min)
    }




}


class MyPoint(val y :Int, val x : Int, val w : Int): Comparable<MyPoint>{

    override fun compareTo(other: MyPoint): Int {
        return this.w - other.w
    }

    override fun toString(): String {
        return "MyPoint(y=$y, x=$x, w=$w)"
    }


}