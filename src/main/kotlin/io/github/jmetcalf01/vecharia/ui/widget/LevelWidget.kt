package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Entity
import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

/**
 * Widget for an entity's HP that returns text in the following format:
 *
 * Level XXX
 *
 * Note that the max level is 999.
 *
 * @author Jonathan Metcalf
 *
 * @property entity the entity whose level is being rendered
 */
class LevelWidget(private val entity: Entity) : Widget {
    /**
     * Renders the text as shown above.
     *
     * @author Jonathan Metcalf
     *
     * @param step the Timestep object
     * @return the text representation of the entity's level
     */
    override fun render(step: Timestep): Text {
        if (entity.level < 0 || entity.level > 999) return Text("Level ", Color.GRAY).append("ERR", Color.RED)
        return Text("Level ", Color.GRAY).append(entity.level, Color.WHITE)
    }
}