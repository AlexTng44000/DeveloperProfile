
package com.example.developerprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developerprofile.ui.theme.DeveloperProfileTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.clickable
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.contentDescription

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DeveloperProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        name = "Alex TANGUY ",
                        role = "Développeur Android junior",
                        description = "Étudiant en informatique, passionné par le développement mobile.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun ProfileScreen(
    name: String,
    role: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        ProfileHeader(
            name = name,
            role = role,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = description,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Compétences",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 24.dp)
        )

        SkillItem(skill = "Kotlin")
        SkillItem(skill = "Jetpack Compose")
        SkillItem(skill = "Git")
        SkillItem(skill = "Android Studio")

        ContactInfo(
            availability = "Disponible pour un nouveau poste"
        )

        ProfileAction(
            label = "Contacter le développeur",
            onClick = {
                // Contact action
            }
        )

    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    DeveloperProfileTheme {
        ProfileScreen(
            name = "Alex TANGUY",
            role = "Développeur Android junior",
            description = "Étudiant en informatique, passionné par le développement mobile."
        )
    }
}
@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = role,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Text(
            text = skill,
            modifier = Modifier.padding(12.dp)
        )
    }
}
@Composable
fun ContactInfo(
    availability: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = availability,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier.padding(top = 20.dp)
    )
}
@Composable
fun ProfileAction(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable(
                role = Role.Button,
                onClick = onClick
            )
            .semantics {
                contentDescription = label
            },
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun SecondProfilePreview() {
    DeveloperProfileTheme {
        ProfileScreen(
            name = "Camille Durand",
            role = "Développeuse Android confirmée",
            description = "Développeuse spécialisée dans la création d'applications Android modernes."
        )
    }
}

