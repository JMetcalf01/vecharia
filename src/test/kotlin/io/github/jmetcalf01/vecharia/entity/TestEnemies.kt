package io.github.jmetcalf01.vecharia.entity

import io.github.jmetcalf01.vecharia.render.Text


class TestEnemies {
    class Goblin : Enemy(Text("Goblin"))
    class Dragon : Enemy(Text("Dragon"))
    class NoName : Enemy(Text(""))
}