package com.dhruv.textstyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dhruv.textstyle.ui.theme.TextStyleTheme

class TextCharFontColor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextStyleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    ) {
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)){
                        TextFontAlignColor()
                    }
                }
            }
        }
    }
}

@Composable
fun TextFontAlignColor( modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondary)
            .width(200.dp)
            .padding(20.dp),
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        fontSize=MaterialTheme.typography.bodyLarge.fontSize,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CharacterFontAlignColor() {
    Text(buildAnnotatedString {
        withStyle(style= ParagraphStyle(textAlign = TextAlign.Center)){
            withStyle(style = SpanStyle(
                color = Color.Blue,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )  ){
                append("A")
            }

            append("BC")
            append("D")
        }

    }, Modifier.width(200.dp))
    
}

@Composable
fun TextDotMaxlines() {
    Text(text = "TextDotMaxlines ".repeat(20),
        maxLines =2,
        overflow = TextOverflow.Ellipsis)
    
}

@Preview(showBackground = true)
@Composable
fun TextCharFontColorPreview() {
    TextStyleTheme {
        Column (modifier = Modifier
            .fillMaxSize()){
            TextFontAlignColor()
            CharacterFontAlignColor()
            TextDotMaxlines()
        }

    }
}