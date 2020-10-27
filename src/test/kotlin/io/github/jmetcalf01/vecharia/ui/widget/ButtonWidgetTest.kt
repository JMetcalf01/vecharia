package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ButtonWidgetTest {

    @Test
    fun testBlank() {
        val buttonWidget = ButtonWidget(Text(""), Text(""))
        assertEquals("[ERROR!]", buttonWidget.render(Timestep()).toString())
    }

    @Test
    fun testBlankWithLength() {
        val buttonWidget = ButtonWidget(Text(""), Text(""),20)
        assertEquals("[       ERROR!       ]", buttonWidget.render(Timestep()).toString())
    }

    @Test
    fun testGoodFit() {
        val buttonWidget = ButtonWidget(Text("Test"), Text("T"))
        assertEquals("[Test (T)]", buttonWidget.render(Timestep()).toString())
    }

    @Test
    fun testMoreSpaces() {
        val buttonWidget = ButtonWidget(Text("Test"), Text("T"), 12)
        assertEquals("[  Test (T)  ]", buttonWidget.render(Timestep()).toString())
    }
}