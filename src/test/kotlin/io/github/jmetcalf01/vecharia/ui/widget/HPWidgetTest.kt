package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HPWidgetTest {

    @Test
    fun testTooMuchHP() {
        val player = Player()
        val hpWidget = HPWidget(player)
        player.maxHealth = 100.0f
        player.health = 110.0f
        assertEquals("HP[       ERROR!       ]", hpWidget.render(Timestep()).toString())
    }

    @Test
    fun testGreenHealth() {
        val player = Player()
        val hpWidget = HPWidget(player)
        player.maxHealth = 100.0f
        player.health = 100.0f
        val test = Text.flatten_t(hpWidget.render(Timestep()))
        assertEquals(Text("HP", Color.WHITE), Text.parent_t(test))
        assertEquals(Text("[", Color.GRAY), test.children[0])
        assertEquals(Text("*".repeat(20), Color.GREEN), test.children[1])
        assertEquals(Text(" ".repeat(0), Color.GRAY), test.children[2])
        assertEquals(Text("]", Color.GRAY), test.children[3])
    }

    @Test
    fun testYellowHealth() {
        val player = Player()
        val hpWidget = HPWidget(player)
        player.maxHealth = 100.0f
        player.health = 69.0f
        val test = Text.flatten_t(hpWidget.render(Timestep()))
        assertEquals(Text("HP", Color.WHITE), Text.parent_t(test))
        assertEquals(Text("[", Color.GRAY), test.children[0])
        assertEquals(Text("*".repeat(13), Color.YELLOW), test.children[1])
        assertEquals(Text(" ".repeat(7), Color.GRAY), test.children[2])
        assertEquals(Text("]", Color.GRAY), test.children[3])
    }

    @Test
    fun testRedHealth() {
        val player = Player()
        val hpWidget = HPWidget(player)
        player.maxHealth = 100.0f
        player.health = 39.0f
        val test = Text.flatten_t(hpWidget.render(Timestep()))
        assertEquals(Text("HP", Color.WHITE), Text.parent_t(test))
        assertEquals(Text("[", Color.GRAY), test.children[0])
        assertEquals(Text("*".repeat(7), Color.RED), test.children[1])
        assertEquals(Text(" ".repeat(13), Color.GRAY), test.children[2])
        assertEquals(Text("]", Color.GRAY), test.children[3])
    }

    @Test
    fun testZeroHealth() {
        val player = Player()
        val hpWidget = HPWidget(player)
        player.maxHealth = 100.0f
        player.health = 0.0f
        val test = Text.flatten_t(hpWidget.render(Timestep()))
        assertEquals(Text("HP", Color.WHITE), Text.parent_t(test))
        assertEquals(Text("[", Color.GRAY), test.children[0])
        assertEquals(Text("*".repeat(0), Color.RED), test.children[1])
        assertEquals(Text(" ".repeat(20), Color.GRAY), test.children[2])
        assertEquals(Text("]", Color.GRAY), test.children[3])
    }

    @Test
    fun testNegHealth() {
        val player = Player()
        val hpWidget = HPWidget(player)
        player.maxHealth = 100.0f
        player.health = -10.0f
        assertEquals("HP[       ERROR!       ]", hpWidget.render(Timestep()).toString())
    }
}