package com.example.composepractice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice1.ui.theme.ComposePractice1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePractice1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePractice1Theme {
        Greeting("Android")
    }
}

// 세로
@Preview(showBackground = true)
@Composable
fun kotlinWorldBlogColumn() {
    Column {
        Text(text = "Kotlin World")
        Text(text = "Blog")
    }
}

// 가로
@Preview(showBackground = true)
@Composable
fun kotlinWorldBlogRow() {
    Row {
        Text(text = "Kotlin World", fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold)
        Text(text = "Blog", color = Color.Blue)
    }
}

// 박스
@Preview(showBackground = true)
@Composable
fun kotlinWorldBlogBox() {
    Box(modifier = Modifier
        .fillMaxWidth()     // 너비 맥스로
        .height(100.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column {
            Text(
                text = "Kotlin World",
                textAlign = TextAlign.Center
            )
            Text(text = "Hello World")
        }
    }
}

// 그림자
@Preview(showBackground = true)
@Composable
fun kotlinWorldBlogShadow() {
    val offset = Offset(5.0f, 10.0f)    // 변수 사용 가능

    Text(
        text = "Kotlin World",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset,
                blurRadius = 3f
            )
        )
    )
}

// 폰트 패밀리
@Preview(showBackground = true)
@Composable
fun kotlinWorldBlogFontFamily() {
    Column {
        Text(text = "Kotlin World", fontFamily = FontFamily.Serif)
        Text(text = "Kotlin World", fontFamily = FontFamily.SansSerif)
    }
}

// 텍스트 내 여러 스타일
@Preview(showBackground = true)
@Composable
fun kotlinWorldBlogMultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("K")
            }
            append("otlin ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        }
    )
}

// 단락 여부
@Preview(showBackground = true)
@Composable
fun kotlinWorldBlogParagraphStyle() {
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("Kotlin\n")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("World\n")
                }
                append("Blog")
            }
        }
    )
}

// 최대 줄 수 + 반복 + 초과 시 ... 표시
@Preview(showBackground = true)
@Composable
fun KotlinWorldBlogLongText() {
    Text(text = "Kotlin World".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

// 텍스트 선택 가능, 불가능
@Preview(showBackground = true)
@Composable
fun KotlinWorldBlogSelectableText() {
    Column {
        SelectionContainer {
            Text(text = "이것은 선택이 가능합니다!")
        }
        DisableSelection {
            Text(text = "이것은 선택이 불가능하구요!")
        }
    }
}