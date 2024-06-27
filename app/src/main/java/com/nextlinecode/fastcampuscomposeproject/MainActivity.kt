@file:OptIn(ExperimentalMaterial3Api::class)

package com.nextlinecode.fastcampuscomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nextlinecode.fastcampuscomposeproject.model.CardData
import com.nextlinecode.fastcampuscomposeproject.ui.ch4.EffectEx
import com.nextlinecode.fastcampuscomposeproject.ui.ch4.RadioButtonWithText
import com.nextlinecode.fastcampuscomposeproject.ui.ch4.TodoInput
import com.nextlinecode.fastcampuscomposeproject.ui.ch4.TopLevel
import com.nextlinecode.fastcampuscomposeproject.ui.theme.FastcampusComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FastcampusComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //ConstraintLayoutEx()
                    //ConstraintSetEx()
                    //ConstraintLayoutEx2()
                    /*Column(modifier = Modifier.fillMaxWidth()) {
                        CardEx(cardData = cardData)
                        CardEx(cardData = cardData)
                        CardEx(cardData = cardData)
                    }*/
                    //CanvasEx()
                    //DialogEx()
                    //CustomDialogEx()
                    //DropDownMenuEx()
                    //BottomAppBarEx()
                    //PyeongToSquareMeter()
                    //AnimationEx()
                    //AnimationEx2()
                    //EffectEx()
                    TopLevel()
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FastcampusComposeProjectTheme {
        //ConstraintLayoutEx()
        //ConstraintSetEx()
        //ConstraintLayoutEx2()
        //CardEx(cardData = cardData)
        //CanvasEx()
        //DialogEx()
        //CustomDialogEx()
        //DropDownMenuEx()
        //SnackbarEx()
        //BottomAppBarEx()
        //PyeongToSquareMeter()
        //AnimationEx()
        //AnimationEx2()
        //EffectEx()
        TodoInput(text = "", onTextChange = {}) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() {
    FastcampusComposeProjectTheme {
        RadioButtonWithText(
            "라디오 버튼",
            Color.Red,
            true,
            onClick = {}
        )
    }
}

val cardData = CardData(
    imageUri = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part1-chapter3/main/part1-chapter3-10/app/src/main/res/drawable-xhdpi/wall.jpg",
    imageDescription = "엔텔로프 캐년",
    author = "Dalinaum",
    description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
)