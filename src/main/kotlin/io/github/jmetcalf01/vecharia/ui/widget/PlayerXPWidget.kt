package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

/**
 * Widget for an player's XP that returns text in the following format:
 *
 * XP[********************]
 *
 * Note that the color of the bar is always yellow.
 *
 * @author Jonathan Metcalf
 *
 * @property player the player whose XP is being rendered
 */
class PlayerXPWidget(private val player: Player) : Widget {
    /**
     * Renders the text as shown above.
     *
     * @author Jonathan Metcalf
     *
     * @param step the Timestep object
     * @return the text representation of the player's XP
     */
    override fun render(step: Timestep): Text {
        return Text("XP", Color.WHITE).append(Utility.percentBar((player.currentXP.toFloat() / player.nextLevelXP), 10, Color.YELLOW))
    }
}