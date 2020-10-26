package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text

object Utility {

    private const val BAR_CHAR: String = "*"

    /**
     * This method prints a bar in the format of:
     * [*******************]
     * This can be used for Health, XP, etc.
     * Based on the inputted percent, it displays some number of them
     * as colored a certain color, and others default to gray.
     * If it changes from green to red, then asterisks that would normally
     * be white instead disappear.
     *
     * @author Jonathan Metcalf
     *
     * @param percent the percent of the bar to be filled
     * @param color the color of the bar (or null if it changes from green to red)
     * @return the Text containing the bar
     */
    fun percentBar(percent: Float, color: Color? = null): Text {
        val text = Text("[", Color.GRAY)
        val coloredBars = (20 * percent).toInt()
        text.append(Text(BAR_CHAR.repeat(coloredBars), color ?: getHealthColor(percent)))
        text.append(Text(BAR_CHAR.repeat(20 - coloredBars), if (color != null) Color.GRAY else Color.CLEAR))
        text.append(Text("]", Color.GRAY))
        return text
    }

    /**
     * Returns a color based on the percent of health.
     *
     * Above 70% is Green
     * 40-70% is Yellow
     * Below 40% is Red
     *
     * @param percent
     * @return
     */
    private fun getHealthColor(percent: Float): Color {
        return when {
            percent > 0.7 -> Color.GREEN
            percent > 0.4 -> Color.YELLOW
            else -> Color.RED
        }
    }
}