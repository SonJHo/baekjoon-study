import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

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

