package io.github.jmetcalf01.vecharia

import kotlinx.coroutines.*

val scope = newSingleThreadContext("M")

fun main() = runBlocking(scope) {


    launch(newSingleThreadContext("A")) {
        while (true) {
            delay(9500)
            println("${Thread.currentThread().name}: queuing")
            withContext(scope) {
                println("A: Running on ${Thread.currentThread().name}")
            }
        }
    }

    // Start queuing
    launch(newSingleThreadContext("B")) {
        while (true) {
            delay(4500)
            println("${Thread.currentThread().name}: queuing")
            launch(scope) {
                println("B: Running on ${Thread.currentThread().name}")
            }
        }
    }

    while (true) {
        try {
            Thread.sleep(10000)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        println("Accepting backlog of stuff")
        yield()
        println("==========================================\n")
    }
}