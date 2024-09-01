fun main() {


    print("수연이 쉬는시간(분):")
    var set = readln().toInt() * 60
    val timer = Timer(set)
    val thread = Thread(timer, "thread-timer")
    thread.start()



    while (true) {
        showOption()
        val input = readln().trim()
        if (!thread.isAlive){
            println("쉬는 시간 끝!")
            break
        }
        if (input == "1") {
            print("추가할 시간(분):")
            val plusTime = readln().trim().toInt()
            timer.time += plusTime * 60
            println("수연이 남은 쉬는시간: ${timer.time}")


        } else if (input == "2") {
            println("수연이 남은 쉬는시간: ${timer.time}")

        } else if (input == "3") {
            break
        } else {
            println("에엑 오류")
        }

    }

}

private fun showOption() {
    println("1. 쉬는시간 추가 해주기")
    println("2. 남은 쉬는시간 보기")
    println("3. 종료")
}


private class Timer(@Volatile var time: Int) : Runnable {
    override fun run() {
        while (true) {
            time--
            Thread.sleep(1000)
            if (time < 0) {
                println("떙떄얘떄얘ㄸ얘 수연이 일어나~~~~~~~~~~ 쉬는시간 끝")
                println("떙떄얘떄얘ㄸ얘 수연이 일어나~~~~~~~~~~ 쉬는시간 끝")
                println("떙떄얘떄얘ㄸ얘 수연이 일어나~~~~~~~~~~ 쉬는시간 끝")
                println("떙떄얘떄얘ㄸ얘 수연이 일어나~~~~~~~~~~ 쉬는시간 끝")
                println("떙떄얘떄얘ㄸ얘 수연이 일어나~~~~~~~~~~ 쉬는시간 끝")
                println("떙떄얘떄얘ㄸ얘 수연이 일어나~~~~~~~~~~ 쉬는시간 끝")
                break
            }
        }
    }

}

