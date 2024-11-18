package com.suren.jetpackcomponsetutorial.ui.theme.activity.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import com.suren.jetpackcomponsetutorial.ui.theme.MyTheme
import com.suren.jetpackcomponsetutorial.ui.theme.lightGreen
import com.suren.jetpackcomponsetutorial.ui.theme.model.UserProfile
import com.suren.jetpackcomponsetutorial.ui.theme.model.userProfileList
import com.suren.jetpackcomponsetutorial.R

class LazyListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                UsersApplication(userProfileList)
            }
        }
    }
}

@Composable
fun UsersApplication(userProfiles: List<UserProfile> = userProfileList) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UserListScreen(userProfileList, navController)
        }
        composable(
            route = "user_details/{userId}", arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            UserProfileDetailsScreen(navBackStackEntry.arguments!!.getInt("userId"), navController)
        }
    }
}

@Composable
fun UserListScreen(userProfiles: List<UserProfile>, navController: NavHostController) {
    Scaffold(topBar = { AppBar("Users List", Icons.Default.Home) {} }, content = { padding ->
        Surface(
            modifier = Modifier
                .padding(padding)
                .background(Color.Yellow),
        ) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile) {
                        navController.navigate("user_details/${userProfile.id}")
                    }
                }
            }
        }
    })

}

@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight(align = Alignment.Top)
            .background(Color.White)
            .clickable(onClick = { clickAction.invoke() }),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProfilePicture(userProfile.image, userProfile.status, 60.dp)
            ProfileContent(userProfile.name, userProfile.status)
        }
    }
}

@Composable
fun ProfilePicture(image: Int, isOnline: Boolean, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = if (isOnline) lightGreen else Color.Red),
        modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        /*Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )*/

        val painter =
            rememberImagePainter("https://www.kasandbox.org/programming-images/avatars/leaf-blue.png") {
                crossfade(true)
                placeholder(R.drawable.suren)
                error(R.drawable.suren)
            }

        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(userName: String, isOnline: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight()
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onSurface.copy(
                alpha = if (isOnline) 1f else 0.5f
            )
        ) {
            Text(text = userName, style = MaterialTheme.typography.headlineSmall)
        }
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onSurface.copy(
                alpha = 0.5f
            )
        ) {
            Text(
                text = if (isOnline) "Active now" else "Offline",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(navigationIcon = {
        Icon(
            imageVector = icon,
            contentDescription = "home icons",
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .clickable(onClick = { iconClickAction.invoke() })
        )
    }, title = { Text(title) })
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    MyTheme {
        UsersApplication()
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsScreenPreview() {
    MyTheme {
        UserProfileDetailsScreen(userId = 0, navController = null)
    }
}

@Composable
fun UserProfileDetailsScreen(userId: Int, navController: NavHostController?) {
    val userProfile = userProfileList.first { it.id == userId }
    Scaffold(topBar = {
        AppBar(userProfile.name, Icons.AutoMirrored.Filled.ArrowBack) {
            navController?.navigateUp()
        }
    },
        content = { p ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(p)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    ProfilePicture(userProfile.image, userProfile.status, 240.dp)
                    ProfileContent(userProfile.name, userProfile.status)
                }
            }
        })
}

