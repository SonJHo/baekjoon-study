import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val values = br.readLine().split(" ").map { it.toInt() }

    val deque = ArrayDeque<Int>()

    for (i in list.indices){
        if(list[i] == 0){
            deque.addFirst(values[i])
        }
    }

    val m =br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    for (i in 1.. m){
        deque.addLast(st.nextToken().toInt())
        sb.append("${deque.pollFirst()} ")
    }
    println(sb)

}




