package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HPWidgetTest {

    @Test
    fun testHealthColors() {
        val player = Player()
        val hpWidget = HPWidget(player)
        player.maxHealth = 100.0f

        player.health = 110.0f
        assertEquals(hpWidget.render(Timestep()).str, "       ERROR!       ")
        assertEquals(hpWidget.render(Timestep()).color, Color.RED)

        player.health = 100.0f
        assertEquals(hpWidget.render(Timestep()).str, "[")
        assertEquals(hpWidget.render(Timestep()).color, Color.GRAY)
        assertEquals(hpWidget.render(Timestep()).children[0], Text("*".repeat(20), Color.GREEN))
        assertEquals(hpWidget.render(Timestep()).children[1], Text("", Color.GRAY))
        assertEquals(hpWidget.render(Timestep()).children[2], Text("]", Color.GRAY))

        player.health = 69.0f
        assertEquals(hpWidget.render(Timestep()).str, "[")
        assertEquals(hpWidget.render(Timestep()).color, Color.GRAY)
        assertEquals(hpWidget.render(Timestep()).children[0], Text("*".repeat(13), Color.YELLOW))
        assertEquals(hpWidget.render(Timestep()).children[1], Text(" ".repeat(7), Color.GRAY))
        assertEquals(hpWidget.render(Timestep()).children[2], Text("]", Color.GRAY))

        player.health = 39.0f
        assertEquals(hpWidget.render(Timestep()).str, "[")
        assertEquals(hpWidget.render(Timestep()).color, Color.GRAY)
        assertEquals(hpWidget.render(Timestep()).children[0], Text("*".repeat(7), Color.RED))
        assertEquals(hpWidget.render(Timestep()).children[1], Text(" ".repeat(13), Color.GRAY))
        assertEquals(hpWidget.render(Timestep()).children[2], Text("]", Color.GRAY))

        player.health = 0.0f
        assertEquals(hpWidget.render(Timestep()).str, "[")
        assertEquals(hpWidget.render(Timestep()).color, Color.GRAY)
        assertEquals(hpWidget.render(Timestep()).children[0], Text("*".repeat(0), Color.RED))
        assertEquals(hpWidget.render(Timestep()).children[1], Text(" ".repeat(20), Color.GRAY))
        assertEquals(hpWidget.render(Timestep()).children[2], Text("]", Color.GRAY))

        player.health = -10.0f
        assertEquals(hpWidget.render(Timestep()).str, "       ERROR!       ")
        assertEquals(hpWidget.render(Timestep()).color, Color.RED)
    }
}