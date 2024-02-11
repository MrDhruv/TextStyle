package com.dhruv.textstyle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dhruv.textstyle.ui.theme.TextStyleTheme

class TextFieldStyle : ComponentActivity() {
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
                        TextFieldColorFocus()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldColorFocus() {
    var text by remember {
        mutableStateOf("Type here....")
    }
    TextField(value =text, 
        onValueChange ={newText-> text=newText } ,
        label={ Text(text = "Title")},
        maxLines = 2,
        leadingIcon = {
        IconButton(onClick = { /*TODO*/ }) {
             Icon(imageVector = Icons.Filled.Email, contentDescription ="" )
            }

        },
        trailingIcon = {
            IconButton(onClick = { Log.d("","Checked icon clicked") }) {
                Icon(imageVector = Icons.Filled.Check, contentDescription ="Checked" )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldStylePreview() {
    TextStyleTheme {
        Column (modifier = Modifier
            .fillMaxSize()){
            TextFieldColorFocus()
        }

    }
}