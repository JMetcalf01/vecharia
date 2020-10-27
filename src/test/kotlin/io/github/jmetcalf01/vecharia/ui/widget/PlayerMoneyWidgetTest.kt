package io.github.jmetcalf01.vecharia.ui.widget

import io.github.jmetcalf01.vecharia.entity.Player
import io.github.jmetcalf01.vecharia.render.Color
import io.github.jmetcalf01.vecharia.render.Text
import io.github.jmetcalf01.vecharia.render.Timestep
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerMoneyWidgetTest {

    @Test
    fun testNegativeMoney() {
        val player = Player()
        val moneyWidget = PlayerMoneyWidget(player)
        player.money = -10
        assertEquals(Text("O ", Color.YELLOW).append("ERROR", Color.RED), moneyWidget.render(Timestep()))
    }

    @Test
    fun testLowMoney() {
        val player = Player()
        val moneyWidget = PlayerMoneyWidget(player)
        player.money = 1
        assertEquals(Text("O ", Color.YELLOW).append("1", Color.WHITE), moneyWidget.render(Timestep()))
    }

    @Test
    fun testMaxMoney() {
        val player = Player()
        val moneyWidget = PlayerMoneyWidget(player)
        player.money = 999_999_999
        assertEquals(Text("O ", Color.YELLOW).append("999,999,999", Color.WHITE), moneyWidget.render(Timestep()))
    }

    @Test
    fun testComma() {
        val player = Player()
        val moneyWidget = PlayerMoneyWidget(player)
        player.money = 10_325_123
        assertEquals(Text("O ", Color.YELLOW).append("10,325,123", Color.WHITE), moneyWidget.render(Timestep()))
    }

    @Test
    fun testTooMuchMoney() {
        val player = Player()
        val moneyWidget = PlayerMoneyWidget(player)
        player.money = 1_000_000_000
        assertEquals(Text("O ", Color.YELLOW).append("ERROR", Color.RED), moneyWidget.render(Timestep()))
    }
}