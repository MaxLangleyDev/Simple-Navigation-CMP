package navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SimpleNavController(initialScreen: Screen) {

    private val _currentScreen = MutableStateFlow(initialScreen)
    val currentScreen: StateFlow<Screen> = _currentScreen

    private val backStack: MutableList<Screen> = mutableListOf()

    fun navigateTo(screen: Screen){

        backStack.add(_currentScreen.value)

        _currentScreen.update { screen }

    }

    fun navigateBack(){

        _currentScreen.update { backStack.last() }

        backStack.removeLast()

    }

}