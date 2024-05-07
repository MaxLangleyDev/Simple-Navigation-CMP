import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navigation.Screen
import navigation.SimpleNavController

@Composable
fun App() {
    MaterialTheme {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val navController = remember { SimpleNavController(Screen.Screen1) }
            val currentScreen by navController.currentScreen.collectAsState()

            Screen1(visible = currentScreen == Screen.Screen1, navController = navController)
            Screen2(visible = currentScreen == Screen.Screen2, navController = navController)
            Screen3(visible = currentScreen == Screen.Screen3, navController = navController)

        }
    }
}

@Composable
fun Screen1(
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

            Text( text = "Screen 1" )

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

            Text( text = "Screen 2" )

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

            Text( text = "Screen 3" )

            Button(
                onClick = { navController.navigateBack() }
            ){ Text("Go Back") }

        }
    }
}


