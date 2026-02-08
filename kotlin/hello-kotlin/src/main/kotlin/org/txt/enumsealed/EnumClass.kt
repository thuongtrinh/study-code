package org.txt.hello.org.txt.enumsealed

enum class State {
    IDLE, RUNNING, FINISHED
}

fun checkState(state: State) {
    when (state) {
        State.IDLE -> println("Đang chờ...")
        State.RUNNING -> println("Đang chạy...")
        State.FINISHED -> println("Đã xong!")
    }
}

fun main() {
    checkState(State.RUNNING)
}