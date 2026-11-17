package com.waenhancer.config

object HookingModePolicy {
    const val KEY = "hooking_mode"
    const val CUSTOMIZATIONS_KEY = "hooking_mode_customizations"

    const val BALANCED = "balanced"
    const val LIGHTWEIGHT = "lightweight"
    const val COMPATIBILITY = "compatibility"
    const val CUSTOMIZED = "customized"

    @JvmStatic
    @JvmOverloads
    fun normalize(mode: String?, isPro: Boolean = false): String {
        val resolved = mode?.trim()?.lowercase() ?: BALANCED
        return when (resolved) {
            LIGHTWEIGHT, CUSTOMIZED -> if (isPro) resolved else BALANCED
            COMPATIBILITY -> COMPATIBILITY
            else -> BALANCED
        }
    }
}
