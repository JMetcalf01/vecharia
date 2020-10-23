package io.github.jmetcalf01.vecharia

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Fetus")
        delay(1000)
        println("Deletus")
    }
}