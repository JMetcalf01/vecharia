package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

class PlayerMoneyWidget(private val player: Player) : Widget {
    override fun render(step: Timestep): Text {
        if (player.money < 0 || player.money > 999_999_999) return Text("O ", Color.YELLOW).append("ERROR", Color.RED)
        return Text("O ", Color.YELLOW).append("%,d".format(player.money), Color.WHITE)
    }
}