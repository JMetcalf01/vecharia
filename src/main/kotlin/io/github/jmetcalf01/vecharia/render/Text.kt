package io.github.jmetcalf01.vecharia.render

import org.jetbrains.annotations.TestOnly
import java.util.stream.Collectors

/**
 * Text object that contains a string of characters and a specific color.
 * Contains a list of children Texts.
 *
 * @author Jonathan Metcalf and Matt Worzala
 *
 * @see Color
 *
 * @property str the string of characters
 * @property color the color of the string
 */
class Text(var str: String, var color: Color = Color.WHITE) {
    companion object {
        private const val EMPTY_CHAR: String = " "

        /**
         * Given a text and a length, returns the text with padded characters on the right side to reach the length.
         * If the length is less than the current text length, the same text is returned.
         *
         * For example, "Hello World" when given a length of 15 would become "Hello World    ".
         *
         * @author Matt Worzala
         *
         * @param text the text to alter
         * @param length the length that is padded to
         * @return the new padded text
         */
        fun ljust(text: Text, length: Int): Text = text.append(Text(EMPTY_CHAR.repeat((length - text.length).coerceAtLeast(0))))

        /**
         * Given a text and a length, returns the text with padded characters on the left side to reach the length.
         * If the length is less than the current text length, the same text is returned.
         *
         * For example, "Hello World" when given a length of 15 would become "    Hello World".
         *
         * @author Matt Worzala
         *
         * @param text the text to alter
         * @param length the length that is padded to
         * @return the new padded text
         */
        fun rjust(text: Text, length: Int): Text = Text(EMPTY_CHAR.repeat((length - text.length).coerceAtLeast(0))).append(text)

        /**
         * Given a text and a length, returns the text with padded characters on both sides to reach the length.
         * If the length is less than the current text length, the same text is returned.
         *
         * For example, "Hello World" when given a length of 15 would become "  Hello World  ".
         *
         * @author Matt Worzala
         *
         * @param text the text to alter
         * @param length the length that is padded to
         * @return the new padded text
         */
        fun cjust(text: Text, length: Int): Text {
            val rem = (length - text.length).coerceAtLeast(0)
            val pre = if (rem % 2 == 0) rem / 2 else (rem / 2) + 1
            return Text(EMPTY_CHAR.repeat(pre))
                    .append(text)
                    .append(EMPTY_CHAR.repeat(rem - pre))
        }

        /**
         * Flattens the children of the text into its own list.
         * Children's children will become the parent's children.
         *
         * NOTE: This should only be used for testing!
         *
         * @author Matt Worzala
         *
         * @param text the text to be flattened
         * @return the flattened text
         */
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

        /**
         * Returns a given text with a blank list of children.
         *
         * NOTE: This should only be used for testing!
         *
         * @author Matt Worzala
         *
         * @param text
         */
        @TestOnly
        fun parent_t(text: Text) = Text(text.str, text.color)
    }

    private val _children: MutableList<Text> = mutableListOf()
    val children: List<Text> = _children

    val length: Int
        get() = str.length + children.stream().mapToInt(Text::length).sum()

    /**
     * Appends text with a certain color to the Text, adding it to the list of children.
     *
     * @author Matt Worzala
     *
     * @param text the text to be added
     * @param color the color of the text
     */
    fun append(text: Any, color: Color = Color.WHITE) = append(Text(text.toString(), color))

    /**
     * Alternate append method. See above.
     *
     * @author Matt Worzala
     *
     * @param text the Text to be added
     * @return the parent text (allows for chaining)
     */
    fun append(text: Text): Text {
        _children.add(text)
        return this
    }

    /**
     * Overrides the toString() function to print the string, then all of its children's
     * string representations as well.
     *
     * @author Matt Worzala
     *
     * @return the string representation of the text
     */
    override fun toString(): String {
        return str + children.stream().map(Text::toString).collect(Collectors.joining())
    }

    /**
     * Overridden equals() method to check string, color, and children
     *
     * @author Matt Worzala
     *
     * @param other object to check against
     * @return whether it equals the other object
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Text

        if (str != other.str) return false
        if (color != other.color) return false
        if (children != other.children) return false

        return true
    }

    /**
     * Overridden hashCode() method.
     *
     * @author Matt Worzala
     *
     * @return the hashcode
     */
    override fun hashCode(): Int {
        var result = str.hashCode()
        result = 31 * result + color.hashCode()
        result = 31 * result + children.hashCode()
        return result
    }
}

/**
 * Interface to allow Text objects to be rendered in some implementation.
 *
 * @author Matt Worzala
 */
interface TextRenderer {
    /**
     * Given a Text, a TextRenderer must be able to draw a certain Text to the screen in some way.
     *
     * @author Matt Worzala
     *
     * @param text the text to be drawn
     */
    fun draw(text: Text)
}

