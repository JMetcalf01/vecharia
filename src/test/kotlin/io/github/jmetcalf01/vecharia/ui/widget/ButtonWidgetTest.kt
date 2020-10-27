package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ButtonWidgetTest {

    @Test
    fun testBlank() {
        val buttonWidget = ButtonWidget(Text(""))
        assertEquals("[ERROR!]", buttonWidget.render(Timestep()).toString())
    }

    @Test
    fun testBlankWithLength() {
        val buttonWidget = ButtonWidget(Text(""), 20)
        assertEquals("[       ERROR!       ]", buttonWidget.render(Timestep()).toString())
    }

    @Test
    fun testGoodFit() {
        val buttonWidget = ButtonWidget(Text("Test"))
        assertEquals("[Test]", buttonWidget.render(Timestep()).toString())
    }

    @Test
    fun testMoreSpaces() {
        val buttonWidget = ButtonWidget(Text("Test"), 10)
        assertEquals("[   Test   ]", buttonWidget.render(Timestep()).toString())
    }
}