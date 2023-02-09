fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    // CrmmainPage
    Math.minus(3,2)

    // HHLoaginPage
    Math.sum(3, 2)
}


// Core

class Math {
    companion object {

        fun sum(x: Int, y: Int) = x + y
        fun minus(x: Int, y: Int) = x - y

    }
}