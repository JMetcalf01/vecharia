package io.github.jmetcalf01.vecharia.render

/**
 * Every widget must generate text immediately when render() is called that can be drawn to the screen.
 *
 * Examples of widgets include HPWidgets, XPWidgets, LevelWidgets, and more.
 *
 * @author Matt Worzala
 *
 */
interface Widget {
    /**
     * Generate the relevant text for this widget in the current frame.
     *
     * Note: This function is not a coroutine, it must return immediately.
     *
     * @return The Text to render
     */
    fun render(step: Timestep): Text
}