package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// ch04-14
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationEx() {
    var helloWorldVisible by remember { mutableStateOf(true) }
    var isRed by remember { mutableStateOf(false) }


    /*
    * 단계 4 : "backgroundColor"를 "animateColorAsState"로 변경하세요.
    * "targetValue"는 "isRed"에 따라 "Color"를 설정합니다.
    * */
    //val bgColor = Color.LightGray
    val bgColor by animateColorAsState(
        targetValue = if (isRed) Color.Red else Color.White
    )
    val alpha by animateFloatAsState(
        targetValue = if (isRed) 0.8f else 0.5f
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(bgColor)
            .alpha(alpha)
    ) {

        //Text(text = "Hello World!")
        /*
        * 단계 1 : "Text"를 AnimatedVisibility로 감싸고 visible을 "helloWorldVisible"로 지정해봅시다.
        * */
        /*AnimatedVisibility(
            visible = helloWorldVisible,
            enter = scaleIn()
        ) {
            Text(text = "Hello World!")
        }*/
        /*
        * 단계 2 : "enter" 파라미터를 바꾸어봅시다.
        * ex)
        * expandHorizontally() : width가 0에서 점점 커지며 보여짐
        * scaleIn() : 글자가 커지면서 보여짐
        * slideInHorizontally() : 오른쪽으로 슬라이드 하며 보여짐
        * fadeIn() : 보이지 않다가 서서히 보여짐
        * */
        /*AnimatedVisibility(
            visible = helloWorldVisible,
            enter = fadeIn()
        ) {
            Text(text = "Hello World!")
        }*/
        /*
        * 단계 3 : "enter" 값을 덧셈으로 결합해봅시다.
        * "exit"도 적절한 값을 설정해봅시다.
        * */
        AnimatedVisibility(
            visible = helloWorldVisible,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Text(text = "Hello World!")
        }
        Row(
            Modifier.selectable(
                selected = helloWorldVisible,
                onClick = {
                    helloWorldVisible = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = helloWorldVisible,
                onClick = { helloWorldVisible = true }
            )
            Text(
                text = "Hello World 보이기"
            )

        }
        Row(
            Modifier.selectable(
                selected = !helloWorldVisible,
                onClick = {
                    helloWorldVisible = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !helloWorldVisible,
                onClick = { helloWorldVisible = false }
            )
            Text(
                text = "Hello World 감추기"
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "배경색을 바꾸어봅시다.")
        Row(
            Modifier.selectable(
                selected = !isRed,
                onClick = {
                    isRed = false
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !isRed,
                onClick = { isRed = false }
            )
            Text(
                text = "흰색"
            )
        }
        Row(
            Modifier.selectable(
                selected = isRed,
                onClick = {
                    isRed = true
                }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isRed,
                onClick = { isRed = true }
            )
            Text(
                text = "빨간색"
            )
        }
    }
}


// ch04-15
@Composable
fun AnimationEx2() {
    var isDarkMode by remember { mutableStateOf(false) }

    /*
    * 단계 1 : "updateTransition" 수행하고 "targetState"를 "isDarkMode"로 설정합니다.
    * "transition"으로 리턴을 받습니다.
    * */
    val transition = updateTransition(targetState = isDarkMode, label = "다크 모드 트랜지션")
    /*
    * 단계 2 : "transition"에 대해 "animateColor"를 호출해 "backgroundColor"를 받습니다.
    * 배경색상을 만듭시다. false일 때 하얀 배경, true일 때 검은 배경
    * */
    val backgroundColor by transition.animateColor(label = "다크 모드 배경색상 애니메이션") { state ->
        when (state) {
            true -> Color.Black
            false -> Color.White
        }
    }
    // 단계 3 : 글자 색상을 만듭시다.

    val textColor by transition.animateColor(label = "다크 모드 글자 색상 애니메이션") { state ->
        when (state) {
            false -> Color.Black
            true -> Color.White
        }
    }
    /*
    * 단계 4 : "animateFloat" 를 호출해서 알파 값을 만듭시다.
    * */
    val alpha by transition.animateFloat(label = "다크 모드 알파 애니메이션") { state ->
        when (state) {
            false -> 0.7f
            true -> 1f
        }
    }

    /*
        단계 5 : 컬럼에 배경과 알파를 적용합시다.
    * */

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        // 단계 6 : 라디오 버튼에 글자 색을 적용합시다.
        RadioButtonWithText(
            text = "일반 모드",
            color = textColor,
            selected = !isDarkMode
        ) {
            isDarkMode = false
        }
        RadioButtonWithText(
            text = "다크 모드",
            color = textColor,
            selected = isDarkMode
        ) {
            isDarkMode = true
        }
        /*
    단계 7 : CrossFade를 이용해 "isDarkMode"가 참일 경우
    "Row"로 항목을 표현하고 거짓일 경우 "Column" 으로 표현해봅시다.
    **/
        /*Row {
            Box(modifier = Modifier
                .background(Color.Red)
                .size(20.dp)
            ){
                Text("1")
            }
            Box(modifier = Modifier
                .background(Color.Magenta)
                .size(20.dp)
            ){
                Text("2")
            }
            Box(modifier = Modifier
                .background(Color.Blue)
                .size(20.dp)
            ){
                Text("3")
            }
        }*/
        Crossfade(targetState = isDarkMode, label = "") { state ->
            when (state) {
                false -> {
                    Column {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .size(20.dp)
                        ) {
                            Text("1")
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Magenta)
                                .size(20.dp)
                        ) {
                            Text("2")
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .size(20.dp)
                        ) {
                            Text("3")
                        }
                    }
                }

                true -> {
                    Row {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .size(20.dp)
                        ) {
                            Text("A")
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Magenta)
                                .size(20.dp)
                        ) {
                            Text("B")
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .size(20.dp)
                        ) {
                            Text("C")
                        }
                    }
                }
            }
        }
    }


}


@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text, color = color)
    }
}
