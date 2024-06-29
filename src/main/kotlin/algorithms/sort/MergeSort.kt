package algorithms.sort

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() { // 백준 10814 - mergeSort 풀이
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt() //회원수
    val members = arrayOfNulls<Member>(n)

    var st: StringTokenizer
    for (i in 0..<n) {
        st = StringTokenizer(br.readLine())
        val age = st.nextToken().toInt()
        val name = st.nextToken()
        members[i] = Member(age, name)
    }
    println("--oriented--")
    printMembers(members)

    println("--sorted--")
    val sortedMembers = mergeSort(members)
    printMembers(sortedMembers)
}

fun printMembers(members: Array<Member?>){
    for (member in members) {
        println(member)
    }
    println()
}

fun mergeSort(members: Array<Member?>): Array<Member?> {
    if (members.size < 2) {
        return members
    }
    val size = members.size
    val l = 0
    val m = size / 2

    val left = members.copyOfRange(l, m)
    val right = members.copyOfRange(m, size)
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: Array<Member?>, right: Array<Member?>): Array<Member?> {
    val merged = arrayOfNulls<Member>(left.size + right.size)
    var lp = 0
    var rp = 0
    var mp = 0

    while (lp != (left.size) && rp != (right.size)){
        if(left[lp]!!.age <= right[rp]!!.age){
            merged[mp] = left[lp]
            lp++
            mp++
        }else{
            merged[mp] = right[rp]
            rp++
            mp++
        }
    }
    if(lp == (left.size)){
       System.arraycopy(right, rp, merged, mp, right.size - rp )
    }
    if( rp == (right.size)){
        System.arraycopy(left, lp, merged, mp, left.size - lp )
    }

    return merged
}

class Member(val age: Int, val name: String) {

    override fun toString(): String {
        return "$age $name"
    }
}