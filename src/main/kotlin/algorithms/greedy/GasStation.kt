package algorithms.greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    val distanceArr = Array(st.countTokens()){0}

    for (i in distanceArr.indices){
        distanceArr[i] = st.nextToken().toInt()
    }


    val priceArr = Array(n){0}
    st = StringTokenizer(br.readLine())
    for (i in priceArr.indices){
        priceArr[i] = st.nextToken().toInt()
    }

    var totalPrice = 0L
    var cityIndex = 0

    while (true){
        var isBreaked = false
        val nowPrice = priceArr[cityIndex]

        if( cityIndex == n - 1){
            break
        }

        var distanceSum = 0L
        for (i in cityIndex + 1..<n){
            distanceSum +=  distanceArr[i -1]

            if( priceArr[i] < nowPrice){
                totalPrice += distanceSum * nowPrice
                cityIndex = i
                break
            }

            if( i == n-1){
                totalPrice += distanceSum * nowPrice
                isBreaked = true
            }
        }
        if(isBreaked){
            break
        }
    }

    println("${totalPrice}")



}