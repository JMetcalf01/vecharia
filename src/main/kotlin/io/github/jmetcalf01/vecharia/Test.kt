package io.github.jmetcalf01.vecharia

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.entity.TestEnemy
import io.github.jmetcalf01.vecharia.render.*
import io.github.jmetcalf01.vecharia.render.platform.terminal.TerminalTextRenderer
import io.github.jmetcalf01.vecharia.ui.widget.*

fun main() {
    val textRenderer: TextRenderer = TerminalTextRenderer()
    val player = Player()
    val levelWidget = LevelWidget(player)
    val hpWidget = HPWidget(player)
    val xpWidget = PlayerXPWidget(player)
    player.maxHealth = 100.0f

    textRenderer.draw(levelWidget.render(Timestep()))

    println()
    player.health = 100.0f
    textRenderer.draw(hpWidget.render(Timestep()))

    player.health = 69.0f
    textRenderer.draw(hpWidget.render(Timestep()))

    player.health = 39.0f
    textRenderer.draw(hpWidget.render(Timestep()))

    println()
    textRenderer.draw(xpWidget.render(Timestep()))

    player.currentXP = 25
    textRenderer.draw(xpWidget.render(Timestep()))

    player.currentXP = 67
    textRenderer.draw(xpWidget.render(Timestep()))

    println()
    val enemy = TestEnemy(Text("Enemy Dude", Color.RED))
    enemy.health = 30.0F
    enemy.maxHealth = 50.0F
    enemy.level = 3
    val enemyWidget = EnemyWidget(enemy)
    textRenderer.draw(enemyWidget.render(Timestep()))
}