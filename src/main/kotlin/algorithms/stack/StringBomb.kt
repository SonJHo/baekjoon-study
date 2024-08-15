package algorithms.stack

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.text.StringBuilder

fun main() { // 백준 9935 번 문자열 폭발
    // 스택 으로 했다가 메모리 초과 걸려서 stringBuilder로 스택 구현
    val br = BufferedReader(InputStreamReader(System.`in`))


    val sb = StringBuilder(br.readLine())
    val bomb = br.readLine()
    val stack = StringBuilder()


    for (i in sb.indices) {
        stack.append(sb[i])

        if (stack.length >= bomb.length && sb[i] == bomb.last()) {
            val substring = stack.substring(stack.lastIndex + 1 - bomb.length, stack.lastIndex + 1)
            if( substring == bomb){
                stack.delete(stack.lastIndex + 1 - bomb.length, stack.lastIndex + 1)
            }
        }
    }
    if(stack.isEmpty()){
        println("FRULA")
    }else{
        println(stack)
    }
}

