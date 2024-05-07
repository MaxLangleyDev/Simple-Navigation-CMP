package navigation

sealed interface Screen {
    data object Screen1 : Screen
    data object Screen2 : Screen
    data object Screen3 : Screen
}