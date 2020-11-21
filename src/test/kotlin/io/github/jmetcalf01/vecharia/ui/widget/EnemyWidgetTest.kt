package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.TestEnemies
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EnemyWidgetTest {

    @Test
    fun testDragonWidget() {
        val enemy = TestEnemies.Dragon()
        enemy.name = Text("Big Boi Dragon", Color.RED)
        enemy.health = 30.0F
        enemy.maxHealth = 50.0F
        enemy.level = 30
        val enemyWidget = EnemyWidget(enemy)
        assertEquals(
            Text("Big Boi Dragon", Color.RED).append(" | ").append("Level ", Color.GRAY).append("30").append(" | ")
                .append("HP").append("[", Color.GRAY).append("************", Color.YELLOW)
                .append("        ", Color.GRAY).append("]", Color.GRAY).toString(),
            enemyWidget.render(Timestep()).toString()
        )
    }

    @Test
    fun testNoName() {
        val enemy = TestEnemies.NoName()
        enemy.health = 10.0F
        enemy.maxHealth = 10.0F
        enemy.level = 3
        val enemyWidget = EnemyWidget(enemy)
        assertEquals(Text("ERROR! | Level 3 | HP[********************]").toString(), enemyWidget.render(Timestep()).toString())
    }

    @Test
    fun testBadLevel() {
        val enemy = TestEnemies.Goblin()
        enemy.health = 10.0F
        enemy.maxHealth = 10.0F
        enemy.level = -5
        val enemyWidget = EnemyWidget(enemy)
        assertEquals(Text("Goblin | Level ERR | HP[********************]").toString(), enemyWidget.render(Timestep()).toString())
    }

    @Test
    fun testBadHPLevel() {
        val enemy = TestEnemies.Goblin()
        enemy.health = 50.0F
        enemy.maxHealth = 25.0F
        enemy.level = 193
        val enemyWidget = EnemyWidget(enemy)
        assertEquals(Text("Goblin | Level 193 | HP[       ERROR!       ]").toString(), enemyWidget.render(Timestep()).toString())
    }
}