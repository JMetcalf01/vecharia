package io.github.jmetcalf01.vecharia.render.platform.terminal

import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Color.*

private const val ANSI_BLACK    = "\u001B[30m"
private const val ANSI_RED      = "\u001B[31m"
private const val ANSI_GREEN    = "\u001B[32m"
private const val ANSI_YELLOW   = "\u001B[33m"
private const val ANSI_BLUE     = "\u001B[34m"
private const val ANSI_PURPLE   = "\u001B[35m"
private const val ANSI_CYAN     = "\u001B[36m"
private const val ANSI_WHITE    = "\u001B[37m"
private const val ANSI_RESET    = "\u001B[0m"

object TerminalColor {
    private val adapter: Map<Color, String> = mapOf(
            RESET to ANSI_RESET,
            WHITE to ANSI_BLACK,
            GRAY to ANSI_WHITE,
            RED to ANSI_RED,
            YELLOW to ANSI_YELLOW,
            GREEN to ANSI_GREEN,
    )

    fun convert(color: Color): String = adapter[color] ?: ANSI_RESET
}

