package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

/**
 * Widget for a button that returns center-justified (to reach minLength) text in the following format:
 *
 * [ text (keys) ]
 *
 * @author Jonathan Metcalf
 *
 * @property text the text to be printed
 * @property keys the keys that the user would press to call the function of this button
 * @property minLength the length this button must be, as long as it is long enough to display the text
 */
class ButtonWidget(private val text: Text, private val keys: Text, private val minLength: Int = text.str.length) : Widget {
    /**
     * Renders the text as shown above.
     *
     * @param step the Timestep object
     * @return the text representation of the button
     */
    override fun render(step: Timestep): Text {
        if (text.str.isBlank() || keys.str.isBlank())
            return Text("[", Color.WHITE).append(Text.cjust(Text("ERROR!", Color.RED), maxOf("ERROR!".length, minLength))).append("]", Color.WHITE)
        return Text("[", Color.WHITE).append(Text.cjust(text.append(" (").append(keys).append(")"), minLength)).append("]", Color.WHITE)
    }

}