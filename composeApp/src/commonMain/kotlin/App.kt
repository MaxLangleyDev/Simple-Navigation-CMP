import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import navigation.Screen
import navigation.SimpleNavController

@Composable
fun App() {
    MaterialTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {

            val navController = remember { SimpleNavController(Screen.Home) }
            val currentScreen by navController.currentScreen.collectAsState()

            HomeScreen(visible = currentScreen == Screen.Home, navController = navController)
            Screen2(visible = currentScreen == Screen.Screen2, navController = navController)
            Screen3(visible = currentScreen == Screen.Screen3, navController = navController)

        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: SimpleNavController,
    visible: Boolean
){
    if (visible){
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text( text = "Home Screen", fontSize = 24.sp )

            Button(
                onClick = { navController.navigateTo(Screen.Screen2) }
            ){ Text("Go To Screen 2") }

        }
    }
}

@Composable
fun Screen2(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: SimpleNavController,
    visible: Boolean
){
    if (visible){
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text( text = "Screen 2", fontSize = 24.sp  )

            Button(
                onClick = { navController.navigateTo(Screen.Screen3) }
            ){ Text("Go To Screen 3") }

            Button(
                onClick = { navController.navigateBack() }
            ){ Text("Go Back") }

        }
    }
}

@Composable
fun Screen3(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: SimpleNavController,
    visible: Boolean
){
    if (visible){
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text( text = "Screen 3", fontSize = 24.sp  )

            Button(
                onClick = { navController.navigateBack() }
            ){ Text("Go Back") }

        }
    }
}


