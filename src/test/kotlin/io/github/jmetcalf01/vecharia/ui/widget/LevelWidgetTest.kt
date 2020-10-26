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
        assertEquals(Text("Level ", Color.GRAY).append(Text("ERR", Color.RED)), levelWidget.render(Timestep()))

        player.level = 1
        assertEquals(Text("Level ", Color.GRAY).append(Text("1", Color.WHITE)), levelWidget.render(Timestep()))

        player.level = 100
        assertEquals(Text("Level ", Color.GRAY).append(Text("100", Color.WHITE)), levelWidget.render(Timestep()))

        player.level = 1000
        assertEquals(Text("Level ", Color.GRAY).append(Text("ERR", Color.RED)), levelWidget.render(Timestep()))
    }
}