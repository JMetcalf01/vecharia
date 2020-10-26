package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Entity
import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

class LevelWidget(private val entity: Entity) : Widget {
    override fun render(step: Timestep): Text {
        if (entity.level < 0 || entity.level > 999) return Text("Level ", Color.GRAY).append("ERR", Color.RED)
        return Text("Level ", Color.GRAY).append(entity.level, Color.WHITE)
    }
}