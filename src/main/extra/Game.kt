import java.lang.NumberFormatException
import java.util.ArrayDeque
import java.util.ArrayList
import java.util.Queue
import java.util.Random

private lateinit var background: Array<Array<String>>
private lateinit var board: Array<Array<String>>
private const val boardSize = 6
private const val optionAmount = 4
fun main() {
    background = Array(boardSize) { Array(boardSize) { "[씹꽝]" } }
    board = Array(boardSize) { Array(boardSize) { "[__]" } }

    val options = ArrayList<String>()
    options.add("[주례]")
    options.add("[사상]")
    options.add("[개금]")

    //test
    initBackground(options)
    initBoard()
    startGame()
}

private fun startGame() {
    println("== 누가누가 ㅈ댈까?==")
    while (true) {
        printBoard(board)
        var y = 0
        var x = 0
        var input = 0
        while (true) {
            print("뽑을 위치:")
            try {
                input = readln().trim().toInt()
                if (input < 1 || input > boardSize * boardSize) {
                    throw NumberFormatException("1 이상 ${boardSize * boardSize} 이하 가능")
                }

            } catch (e: NumberFormatException) {
                println(e.message)
                continue
            }
            break
        }
        println("뽑은 위치->${input}")
        y = (input - 1) / boardSize
        x = (input - 1) % boardSize
        val isSelect = select(y, x)
        if (isSelect) {
            println("=======결과=======")
            printBoard(background)
            break
        }
        println("----------------------")
    }
}

private fun initBoard() {
    var count = 1
    for (i in board.indices) {
        for (j in board[0].indices) {
            board[i][j] = "[_${count++}_]"
        }
    }
}

private fun initBackground(options: ArrayList<String>) {
    val queue: Queue<String> = ArrayDeque()
    for (i in 1..optionAmount) {
        for (option in options) {
            queue.offer(option)
        }
    }

    val random = Random()
    while (queue.isNotEmpty()) {
        for (i in background.indices) {
            var isBreak = false
            for (j in background[0].indices) {
                val int = random.nextInt(1, 4)
                if (int == 2) {
                    background[i][j] = queue.poll()
                    if (queue.isEmpty()) {
                        isBreak = true
                        break
                    }
                }
            }
            if (isBreak) {
                break
            }
        }
    }
}

private fun select(y: Int, x: Int): Boolean {
    val s = background[y][x]
    return if (s == "[씹꽝]") {
        board[y][x] = "[_꽝_]"
        false
    } else {
        println("${background[y][x]} 당첨!!!!!!!!!!!!!!!!")
        true
    }
}

private fun printBoard(board: Array<Array<String>>) {
    for (strings in board) {
        for (string in strings) {
            print(String.format("%-7s", string))
        }
        println()
    }
}