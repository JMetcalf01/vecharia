package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

/**
 * Widget for a player's money that returns text in the following format:
 *
 * O XXX,XXX,XXX
 *
 * Note that the max amount of money is 1 billion coins.
 *
 * @author Jonathan Metcalf
 *
 * @property player the player whose money is being rendered
 */
class PlayerMoneyWidget(private val player: Player) : Widget {
    /**
     * Renders the text as shown above.
     *
     * @param step the Timestep object
     * @return the text representation of the player's money
     */
    override fun render(step: Timestep): Text {
        if (player.money < 0 || player.money > 999_999_999) return Text("O ", Color.YELLOW).append("ERROR", Color.RED)
        return Text("O ", Color.YELLOW).append("%,d".format(player.money), Color.WHITE)
    }
}