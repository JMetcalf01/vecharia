package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.render.Widget

class ButtonWidget(private val text: Text, private val keys: Text, private val minLength: Int = text.str.length) : Widget {
    override fun render(step: Timestep): Text {
        if (text.str.isBlank() || keys.str.isBlank())
            return Text("[", Color.WHITE).append(Text.cjust(Text("ERROR!", Color.RED), maxOf("ERROR!".length, minLength))).append("]", Color.WHITE)
        return Text("[", Color.WHITE).append(Text.cjust(text.append(" (").append(keys).append(")"), minLength)).append("]", Color.WHITE)
    }

}