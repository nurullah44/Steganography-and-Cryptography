fun main() {
    while (true ) {
        println("Task (hide, show, exit):")
        when (readln()){
            "hide" -> println("Hiding message in image.")
            "show" -> println("Obtaining message from image.")
            "exit" -> {
                println("Bye!")
                break
            }
            else -> println("Wrong task: task")
        }
    }
}
