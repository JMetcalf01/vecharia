package io.github.jmetcalf01.vecharia.render.platform.terminal

import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.TextRenderer
import java.util.stream.Collectors

class TerminalTextRenderer : TextRenderer {
    override fun draw(text: Text) {
        println("${render(text)}${TerminalColor.convert(Color.RESET)}")
    }

    private fun render(text: Text): String
            = "${TerminalColor.convert(text.color)}${text.str}${text.children.stream().map(this::render).collect(Collectors.joining())}"
}