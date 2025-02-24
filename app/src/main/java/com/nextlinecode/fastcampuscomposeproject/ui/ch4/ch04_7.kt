package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


// Ch04-07
@Composable
fun CanvasEx() {
    Canvas(modifier = Modifier.size(20.dp)) {

        /*
        * 단게 1 : 'drawLine' 을 사용해봅시다. 파라미터로 색상, 시작('Offset') 끝('Offset' 타입)을 받습니다.
        * */
        drawLine(Color.Red, Offset(30f, 10f), Offset(50f, 40f))

        /*
        * 단계 2 : 'drawCircle' 을 사용해보세요. 색상, 반지름, 중앙('Offset')
        * */

        drawCircle(Color.Yellow, 10f, Offset(15f, 40f))
        drawRect(Color.Magenta, Offset(30f, 30f), Size(10f, 10f))
        /*
        * 단계 3 : 아래의 규칙으로 그려진 아이콘 'Icons.Filled.Send'를 'drawLine'으로 변경해봅시다.
        * */
        /*
        Icons.Filled.Send
        moveTo(2.01f, 21.0f)
        lineTo(23.0f, 12.0f)
        lineTo(2.01f, 3.0f)
        lineTo(2.0f, 10.0f)
        lineToRelative(15.0f, 2.0f)
        lineToRelative(-15.0f, 2.0f)
        close()*/
        drawLine(Color.Green, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Green, Offset(23.0f, 12.0f), Offset(2.01f, 3.0f))
        drawLine(Color.Green, Offset(2.01f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Green, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Green, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Green, Offset(2.0f, 14.0f), Offset(2.01f, 21.0f))

        /*
        * ImageVector에서는 한붓 그리기 처럼 연속으로 그려집니다.
        * */
    }
}