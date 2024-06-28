import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


var members: MutableList<Member> = mutableListOf()  //실패  고쳐야함

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        val age = st.nextToken().toInt()
        val name = st.nextToken()
        members.add(Member(age, name))
    }
    quickSort(0, members.size - 1)

    for (member in members) {
        println(member)
    }

}

fun quickSort(l: Int, h: Int) {
    val size = h - l + 1
    if (size > 1) {
        var pivot = (l + h) / 2
        val fp = pivot


        var i = l
        while (i < pivot) {
            if (members[i].age > members[pivot].age) {
                val temp = members[i]
                members.removeAt(i)
                members.add(pivot, temp)
                pivot--
                i--
            }
            i++
        }
        var j = fp + 1

        while (j <= h) {

            if (members[j].age < members[pivot].age) {
                val temp = members[j]
                members.removeAt(j)
                members.add(pivot, temp)
                pivot++
            }
            j++
        }

        quickSort(l, pivot - 1)
        quickSort(pivot + 1, h)
    }
}

class Member(val age: Int, val name: String) {
    override fun toString(): String {
        return "$age $name"
    }
}
