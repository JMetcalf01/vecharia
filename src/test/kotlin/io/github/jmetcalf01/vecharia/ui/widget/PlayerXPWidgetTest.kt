package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerXPWidgetTest {

    @Test
    fun testNegativeXP() {
        val player = Player()
        val xpWidget = PlayerXPWidget(player)
        player.currentXP = -10
        assertEquals("XP[  ERROR!  ]", xpWidget.render(Timestep()).toString())
    }

    @Test
    fun testZeroXP() {
        val player = Player()
        val xpWidget = PlayerXPWidget(player)
        player.currentXP = 0
        val test = Text.flatten_t(xpWidget.render(Timestep()))
        assertEquals(Text("XP", Color.WHITE), Text.parent_t(test))
        assertEquals(Text("[", Color.GRAY), test.children[0])
        assertEquals(Text("*".repeat(0), Color.YELLOW), test.children[1])
        assertEquals(Text("*".repeat(10), Color.GRAY), test.children[2])
        assertEquals(Text("]", Color.GRAY), test.children[3])
    }

    @Test
    fun testLowXP() {
        val player = Player()
        val xpWidget = PlayerXPWidget(player)
        player.currentXP = 25
        val test = Text.flatten_t(xpWidget.render(Timestep()))
        assertEquals(Text("XP", Color.WHITE), Text.parent_t(test))
        assertEquals(Text("[", Color.GRAY), test.children[0])
        assertEquals(Text("*".repeat(2), Color.YELLOW), test.children[1])
        assertEquals(Text("*".repeat(8), Color.GRAY), test.children[2])
        assertEquals(Text("]", Color.GRAY), test.children[3])
    }

    @Test
    fun testHighXP() {
        val player = Player()
        val xpWidget = PlayerXPWidget(player)
        player.currentXP = 67
        val t3 = Text.flatten_t(xpWidget.render(Timestep()))
        assertEquals(Text("XP", Color.WHITE), Text.parent_t(t3))
        assertEquals(Text("[", Color.GRAY), t3.children[0])
        assertEquals(Text("*".repeat(6), Color.YELLOW), t3.children[1])
        assertEquals(Text("*".repeat(4), Color.GRAY), t3.children[2])
        assertEquals(Text("]", Color.GRAY), t3.children[3])
    }

    @Test
    fun testTooMuchXP() {
        val player = Player()
        val xpWidget = PlayerXPWidget(player)
        player.currentXP = 110
        assertEquals("XP[  ERROR!  ]", xpWidget.render(Timestep()).toString())
    }
}