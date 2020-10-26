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
        assertEquals(xpWidget.render(Timestep()).str, "[")
        assertEquals(xpWidget.render(Timestep()).color, Color.GRAY)
        assertEquals(xpWidget.render(Timestep()).children[0], Text("*".repeat(0), Color.YELLOW))
        assertEquals(xpWidget.render(Timestep()).children[1], Text("*".repeat(20), Color.GRAY))
        assertEquals(xpWidget.render(Timestep()).children[2], Text("]", Color.GRAY))

        player.currentXP = 25
        assertEquals(xpWidget.render(Timestep()).str, "[")
        assertEquals(xpWidget.render(Timestep()).color, Color.GRAY)
        assertEquals(xpWidget.render(Timestep()).children[0], Text("*".repeat(5), Color.YELLOW))
        assertEquals(xpWidget.render(Timestep()).children[1], Text("*".repeat(15), Color.GRAY))
        assertEquals(xpWidget.render(Timestep()).children[2], Text("]", Color.GRAY))

        player.currentXP = 67
        assertEquals(xpWidget.render(Timestep()).str, "[")
        assertEquals(xpWidget.render(Timestep()).color, Color.GRAY)
        assertEquals(xpWidget.render(Timestep()).children[0], Text("*".repeat(13), Color.YELLOW))
        assertEquals(xpWidget.render(Timestep()).children[1], Text("*".repeat(7), Color.GRAY))
        assertEquals(xpWidget.render(Timestep()).children[2], Text("]", Color.GRAY))

        player.currentXP = 110
        assertEquals(xpWidget.render(Timestep()).toString(), "[       ERROR!       ]")
    }
}