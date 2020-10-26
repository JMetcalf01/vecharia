package io.github.jmetcalf01.vecharia

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.ui.widget.HPWidget
import io.github.jmetcalf01.vecharia.ui.widget.XPWidget

fun main() {
    val player = Player()
    val hpWidget = HPWidget(player)
    val xpWidget = XPWidget(player)
    player.maxHealth = 100.0f

    player.health = 100.0f
    println(hpWidget.render(Timestep()))

    player.health = 69.0f
    println(hpWidget.render(Timestep()))

    player.health = 39.0f
    println(hpWidget.render(Timestep()))

    println()
    println(xpWidget.render(Timestep()))

    player.currentXP = 25
    println(xpWidget.render(Timestep()))

    player.currentXP = 67
    println(xpWidget.render(Timestep()))
}