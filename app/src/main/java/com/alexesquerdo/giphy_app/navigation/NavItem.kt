package com.alexesquerdo.giphy_app.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    internal val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList(),
) {
    data object Home : NavItem("home")
    data object Detail : NavItem("detail", listOf(NavArg.ItemId)) {
        fun createRoute(itemId: String): String = "$baseRoute/$itemId"
    }

    val route = run {
        val argsValues = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argsValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.type }
    }
}

enum class NavArg(val key: String, val type: NavType<*>) {
    ItemId("itemId", NavType.IntType)
}