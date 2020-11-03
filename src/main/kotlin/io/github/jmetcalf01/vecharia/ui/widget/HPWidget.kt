package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Entity
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

/**
 * Widget for an entity's HP that returns text in the following format:
 *
 * HP[********************]
 *
 * Note that the color of the bar depends on the percent of health:
 * 70% - 100% is GREEN
 * 40% -  69% is YELLOW
 * 0%  -  39% is RED
 *
 * @author Jonathan Metcalf
 *
 * @property entity the entity whose HP is being rendered
 */
class HPWidget(private val entity: Entity) : Widget {
    /**
     * Renders the text as shown above.
     *
     * @author Jonathan Metcalf
     *
     * @param step the Timestep object
     * @return the text representation of the entity's HP
     */
    override fun render(step: Timestep): Text {
        return Text("HP", Color.WHITE).append(Utility.percentBar(entity.health / entity.maxHealth, 20))
    }
}