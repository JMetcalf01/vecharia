package io.github.jmetcalf01.vecharia.render

import org.jetbrains.annotations.TestOnly
import java.util.stream.Collectors

class Text(var str: String, var color: Color = Color.WHITE) {
    companion object {
        private const val EMPTY_CHAR: String = " "

        fun ljust(text: Text, length: Int): Text = text.append(Text(EMPTY_CHAR.repeat((length - text.length).coerceAtLeast(0))))

        fun rjust(text: Text, length: Int): Text = Text(EMPTY_CHAR.repeat((length - text.length).coerceAtLeast(0))).append(text)

        fun cjust(text: Text, length: Int): Text {
            val rem = (length - text.length).coerceAtLeast(0)
            val pre = if (rem % 2 == 0) rem / 2 else (rem / 2) + 1
            return Text(EMPTY_CHAR.repeat(pre))
                    .append(text)
                    .append(EMPTY_CHAR.repeat(rem - pre))
        }

        @TestOnly
        fun flatten_t(text: Text): Text {
            fun Text.deep(): List<Text> {
                val all = mutableListOf<Text>()
                all.add(Text(str, color))
                all.addAll(children.map(Text::deep).flatten())
                return all
            }

            val flattened = Text(text.str, text.color)
            text.children.map(Text::deep).flatten().forEach(flattened::append)
            return flattened
        }

        @TestOnly
        fun parent_t(text: Text) = Text(text.str, text.color)
    }

    private val _children: MutableList<Text> = mutableListOf()
    val children: List<Text> = _children

    val length: Int
        get() = str.length + children.stream().mapToInt(Text::length).sum()

    fun append(text: Any, color: Color = Color.WHITE) = append(Text(text.toString(), color))

    fun append(text: Text): Text {
        _children.add(text)
        return this
    }

    override fun toString(): String {
        return str + children.stream().map(Text::toString).collect(Collectors.joining())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Text

        if (str != other.str) return false
        if (color != other.color) return false
        if (children != other.children) return false

        return true
    }

    override fun hashCode(): Int {
        var result = str.hashCode()
        result = 31 * result + color.hashCode()
        result = 31 * result + children.hashCode()
        return result
    }
}

interface TextRenderer {
    fun draw(text: Text)
}

