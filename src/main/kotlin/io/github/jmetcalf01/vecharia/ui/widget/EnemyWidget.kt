package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Enemy
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

/**
 * Widget for an enemy that returns text in the following format:
 *
 * ENEMY_NAME | LEVEL XXX | HP[********************]
 *
 * @author Jonathan Metcalf
 *
 * @property enemy the enemy being rendered
 */
class EnemyWidget(private val enemy: Enemy) : Widget {
    /**
     * Renders the text as shown above.
     *
     * @author Jonathan Metcalf
     *
     * @param step the Timestep object
     * @return the text representation of the enemy
     */
    override fun render(step: Timestep): Text {
        return Text(enemy.name, Color.RED).append(" | ", Color.WHITE).append(LevelWidget(enemy)).append(" | ", Color.WHITE).append(HPWidget(enemy))
    }
}