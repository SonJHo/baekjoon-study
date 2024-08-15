package algorithms.math

fun main() {//백준 1676번 팩토리얼 0의 개수 찾기
    /*
    예를 들어 10!일때 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 *  9 * 10
    결과의 마지막에 0이 붙는 순간은  2*5의 연산이 수행될 때 이다.
    인수분해 해보면 1 * 2 * 3 * (2*2) * (5) * (2*3) * 7 * (2*2*2) * (3* 3) * (2 * 5) 이다
    2 와 5의 쌍의 개수가 곧 뒤에 붙는 0의 개수 하지만 2는 필연적으로 5보다 많이 나오기 때문에
    5의 개수를 세면 됨
    */

    var n = readln().toInt()
    var count = 0

    while (n >= 5){
        count += n/5    // 5의 배수의 개수 가나옴

        n /=5
    }
    println(count)

}