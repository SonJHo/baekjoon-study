fun main() {//백준 9375 - 패션왕 신해빈
 //같은옷 종류 + 안입는 경우 1 로 보고 전체 조합 개수 - 전부 안입는 경우 1

    val t = readln().toInt()

    for (i in 1.. t){
        val n = readln().toInt()

        val map = LinkedHashMap<String, Int>()
        for (i in 1..n) {
            val inputArr = readln().split(" ")
            if (map.containsKey(inputArr[1])) {
                map[inputArr[1]] = map[inputArr[1]]!! + 1
            } else {
                map[inputArr[1]] = 1
            }
        }

        var sum = 1

        for (value in map.values) {
            sum *= value + 1
        }
        println(sum -1)
    }
}
