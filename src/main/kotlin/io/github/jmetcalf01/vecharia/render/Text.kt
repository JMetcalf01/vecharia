package io.github.jmetcalf01.vecharia.render

import java.util.stream.Collectors

class Text(var str: String, var color: Color = Color.WHITE) {
    private val children: MutableList<Text> = mutableListOf()

    fun append(text: Any, color: Color) = append(Text(text.toString(), color))

    fun append(text: Text): Text {
        children.add(text);
        return this;
    }

    override fun toString(): String {
        return str + children.stream().map(Text::toString).collect(Collectors.joining())
    }
}

enum class Color {
    WHITE,
    GRAY,

}