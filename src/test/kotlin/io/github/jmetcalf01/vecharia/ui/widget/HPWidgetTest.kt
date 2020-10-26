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
        assertEquals("[       ERROR!       ]", hpWidget.render(Timestep()).toString())

        player.health = 100.0f
        assertEquals("[", hpWidget.render(Timestep()).str)
        assertEquals(Color.GRAY, hpWidget.render(Timestep()).color)
        assertEquals(Text("*".repeat(20), Color.GREEN), hpWidget.render(Timestep()).children[0])
        assertEquals(Text("", Color.GRAY), hpWidget.render(Timestep()).children[1])
        assertEquals(Text("]", Color.GRAY), hpWidget.render(Timestep()).children[2])

        player.health = 69.0f
        assertEquals("[", hpWidget.render(Timestep()).str)
        assertEquals(Color.GRAY, hpWidget.render(Timestep()).color)
        assertEquals(Text("*".repeat(13), Color.YELLOW), hpWidget.render(Timestep()).children[0])
        assertEquals(Text(" ".repeat(7), Color.GRAY), hpWidget.render(Timestep()).children[1])
        assertEquals(Text("]", Color.GRAY), hpWidget.render(Timestep()).children[2])

        player.health = 39.0f
        assertEquals("[", hpWidget.render(Timestep()).str)
        assertEquals(Color.GRAY, hpWidget.render(Timestep()).color)
        assertEquals(Text("*".repeat(7), Color.RED), hpWidget.render(Timestep()).children[0])
        assertEquals(Text(" ".repeat(13), Color.GRAY), hpWidget.render(Timestep()).children[1])
        assertEquals(Text("]", Color.GRAY), hpWidget.render(Timestep()).children[2])

        player.health = 0.0f
        assertEquals("[", hpWidget.render(Timestep()).str)
        assertEquals(Color.GRAY, hpWidget.render(Timestep()).color)
        assertEquals(Text("*".repeat(0), Color.RED), hpWidget.render(Timestep()).children[0])
        assertEquals(Text(" ".repeat(20), Color.GRAY), hpWidget.render(Timestep()).children[1])
        assertEquals(Text("]", Color.GRAY), hpWidget.render(Timestep()).children[2])

        player.health = -10.0f
        assertEquals("[       ERROR!       ]", hpWidget.render(Timestep()).toString())
    }
}