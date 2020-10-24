package io.github.jmetcalf01.vecharia

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Timestep
import io.github.jmetcalf01.vecharia.ui.widget.PlayerLevelWidget
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val player = Player()
    val levelWidget = PlayerLevelWidget(player)

    println(levelWidget.render(Timestep()))
    player.level = 100
    println(levelWidget.render(Timestep()))
}