package io.github.jmetcalf01.vecharia.render

import java.util.stream.Collectors

class Text(var str: String, var color: Color = Color.WHITE) {
    private val _children: MutableList<Text> = mutableListOf()
    val children: List<Text> = _children

    fun append(text: Any, color: Color = Color.WHITE) = append(Text(text.toString(), color))

    fun append(text: Text): Text {
        _children.add(text)
        return this
    }

    override fun toString(): String {
        return str + children.stream().map(Text::toString).collect(Collectors.joining())
    }
}