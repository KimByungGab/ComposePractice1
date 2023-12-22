package com.example.composepractice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composepractice1.ui.theme.ComposePractice1Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePractice1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposePractice1Theme {
        Greeting2("Android")
    }
}

// 내부 저장소의 이미지
@Preview(showBackground = true)
@Composable
fun diskImage() {
    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "디스크 일반 이미지")
}

// 인터넷에서 이미지 (Glide는 아직 beta)
@Preview(showBackground = true)
@Composable
fun internetImage() {
    AsyncImage(
        model = "https://cdn.discordapp.com/attachments/1056532160636538970/1187804729934348380/image.png?ex=6598385b&is=6585c35b&hm=c51497776fd16f0081480b4f6e356217d14e9d3cf885d032ad225c242f90b952&",
        contentDescription = "인터넷에서 이미지 가져오기"
    )
}