package io.github.jmetcalf01.vecharia.render

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