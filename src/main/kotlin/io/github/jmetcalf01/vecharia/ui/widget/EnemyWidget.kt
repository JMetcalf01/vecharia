package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Enemy
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

class EnemyWidget(private val enemy: Enemy) : Widget {
    override fun render(step: Timestep): Text {
        return Text(enemy.name, Color.RED).append(" | ", Color.WHITE).append(LevelWidget(enemy)).append(" | ", Color.WHITE).append(HPWidget(enemy))
    }
}