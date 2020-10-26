package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

class PlayerXPWidget(private val player: Player) : Widget {
    override fun render(step: Timestep): Text {
        return Text("XP", Color.WHITE).append(Utility.percentBar((player.currentXP.toFloat() / player.nextLevelXP), 10, Color.YELLOW))
    }
}