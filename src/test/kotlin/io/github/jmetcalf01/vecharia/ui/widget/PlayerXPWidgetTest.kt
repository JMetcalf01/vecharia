package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerXPWidgetTest {

    @Test
    fun testXP() {
        val player = Player()
        val xpWidget = XPWidget(player)

        player.currentXP = -10
        assertEquals(xpWidget.render(Timestep()).toString(), "[       ERROR!       ]")

        player.currentXP = 0
        assertEquals("[", xpWidget.render(Timestep()).str)
        assertEquals(Color.GRAY, xpWidget.render(Timestep()).color)
        assertEquals(Text("*".repeat(0), Color.YELLOW), xpWidget.render(Timestep()).children[0])
        assertEquals(Text("*".repeat(10), Color.GRAY), xpWidget.render(Timestep()).children[1])
        assertEquals(Text("]", Color.GRAY), xpWidget.render(Timestep()).children[2])

        player.currentXP = 25
        assertEquals("[", xpWidget.render(Timestep()).str)
        assertEquals(Color.GRAY, xpWidget.render(Timestep()).color)
        assertEquals(Text("*".repeat(2), Color.YELLOW), xpWidget.render(Timestep()).children[0])
        assertEquals(Text("*".repeat(8), Color.GRAY), xpWidget.render(Timestep()).children[1])
        assertEquals(Text("]", Color.GRAY), xpWidget.render(Timestep()).children[2])

        player.currentXP = 67
        assertEquals("[", xpWidget.render(Timestep()).str)
        assertEquals(Color.GRAY, xpWidget.render(Timestep()).color)
        assertEquals(Text("*".repeat(6), Color.YELLOW), xpWidget.render(Timestep()).children[0])
        assertEquals(Text("*".repeat(4), Color.GRAY), xpWidget.render(Timestep()).children[1])
        assertEquals(Text("]", Color.GRAY), xpWidget.render(Timestep()).children[2])

        player.currentXP = 110
        assertEquals("[       ERROR!       ]", xpWidget.render(Timestep()).toString())
    }
}