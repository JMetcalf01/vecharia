package io.github.jmetcalf01.vecharia.render

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TextTest {

    @Test
    fun testAppend() {
        val main = Text("Hello, ")
        main.append("World")
        main.append(Text("!"))

        assertEquals("World", main.children[0].str)
        assertEquals("!", main.children[1].str)
        assertEquals("Hello, World!", main.toString())
    }

    @Test
    fun testToString() {
        val t1 = Text("Hello, World")
        assertEquals("Hello, World", t1.toString())

        val t2 = Text("Hello, ").append("World")
        assertEquals("Hello, World", t2.toString())
    }
}
