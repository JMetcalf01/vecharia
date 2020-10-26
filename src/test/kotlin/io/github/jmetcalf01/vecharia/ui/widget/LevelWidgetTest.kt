package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LevelWidgetTest {

    @Test
    fun testLevel() {
        val player = Player()
        val levelWidget = LevelWidget(player)
        player.level = -1
        assertEquals(Text("Level ", Color.GRAY).append("ERR", Color.RED), levelWidget.render(Timestep()))
    }

    @Test
    fun testLowLevel() {
        val player = Player()
        val levelWidget = LevelWidget(player)
        player.level = 1
        assertEquals(Text("Level ", Color.GRAY).append("1", Color.WHITE), levelWidget.render(Timestep()))
    }

    @Test
    fun testHighLevel() {
        val player = Player()
        val levelWidget = LevelWidget(player)
        player.level = 100
        assertEquals(Text("Level ", Color.GRAY).append("100", Color.WHITE), levelWidget.render(Timestep()))
    }

    @Test
    fun testTooHighLevel() {
        val player = Player()
        val levelWidget = LevelWidget(player)
        player.level = 1000
        assertEquals(Text("Level ", Color.GRAY).append("ERR", Color.RED), levelWidget.render(Timestep()))
    }
}