package io.github.jmetcalf01.vecharia.render.platform.gdx

import io.github.jmetcalf01.vecharia.render.Color

private typealias _Color = com.badlogic.gdx.graphics.Color

object GdxColor {
    private val adapter: Map<Color, _Color> = mapOf(
            Color.RESET to _Color.WHITE,
            Color.WHITE to _Color.WHITE,
            Color.GRAY to _Color.GRAY,
            Color.RED to _Color.RED,
            Color.YELLOW to _Color.YELLOW,
            Color.GREEN to _Color.GREEN
    )

    fun convert(color: Color): _Color = adapter[color] ?: _Color.WHITE
}