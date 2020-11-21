package io.github.jmetcalf01.vecharia.entity

import io.github.jmetcalf01.vecharia.render.Text

abstract class Enemy(var name: Text) : Entity()


/**
 * SHOULD ONLY BE USED FOR TESTING.
 */
class TestEnemy(name: Text) : Enemy(name)