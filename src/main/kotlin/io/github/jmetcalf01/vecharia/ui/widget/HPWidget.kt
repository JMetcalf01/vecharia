package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Entity
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

class HPWidget(private val entity: Entity) : Widget {
    override fun render(step: Timestep): Text {
        return Utility.percentBar(entity.health / entity.maxHealth, 20)
    }
}