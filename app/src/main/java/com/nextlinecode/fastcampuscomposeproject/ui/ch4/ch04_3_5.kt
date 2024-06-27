package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet


// Ch04-03
@Composable
fun ConstraintLayoutEx() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        /*
        * 단계 2 : createRefs()를 이용해서 아래 박스들의 레퍼런스를 가져옵시다.
        * createRefs는 여러개의 레퍼런스를 리턴하니 destruction으로 분해합시다.
        * red, meganta, green, yello 박스가 있습니다.
        * */
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(
            /*
            * 단계 3 : constraintAs 모디파이어를 추가하고 레퍼런스를 전달합시다.
            * 후행 람다로 top, start, end, bottom 앵커를 지정하고
            * linkTo 호출합시다.
            * 인자로는 parent의 앵커(top, start, end, bottom)을 전달해봅시다.
            * */

            // 단계 4 : linkTod의 키워드 인자 margin을 추가합시다.
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )

        Box(
            // 단계 5 : 마젠타 박스를 parent의 start와 end에 연결합시다.
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, 10.dp)
                }
        )

        Box(
            // 단계 6 : 그린 박스를 linkTo를 이용해서 정 가운데로 연결해봅시다.

            // 단계 7 : 앵커 메서드 linkTo 대신에 centerTo 함수를 사용해봅시다.
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
                    centerTo(parent)
                    //centerVerticallyTo(parent)

                }
        )

        Box(
            /*
            * 단계 8 : 옐로우 박스를 마젠타 박스 오른쪽 대각선 아래에 위치해봅시다.
            * linkTo를 쓰고 인자로 parent 대신 그린 박스의 래퍼런스를 사용합시다.
            * */
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )


    }
}

// Ch04-04
@Composable
fun ConstraintSetEx() {
    val constraintSet = ConstraintSet {
        /*
        * 단계 1 : createRefFor로 레드, 마젠타, 그린, 옐로 박스를 위한 레퍼런스를 만듭니다.
        * 파라미터 id로 레퍼런스의 이름을 적어 줍시다. eg. redBox
        * */
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")


        /*
        * 단계 2 : 'constrain' 을 열고 만들었던 레퍼런스를 인자로 넣읍시다.
        * 레드 ,마젠타, 그린, 옐로 박스 레퍼런스에 대해 'constrain' 을 적읍시다.
        * 후행 람다의 내용은 기존에 'constrainAs'에 적어둔 것을 참고핪디ㅏ.
        * */

        constrain(redBox) {
            bottom.linkTo(parent.bottom, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }
        constrain(magentaBox) {
            start.linkTo(parent.start, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }
        constrain(greenBox) {
            centerTo(parent)
        }
        constrain(yellowBox) {
            start.linkTo(greenBox.end)
            top.linkTo(greenBox.bottom)
        }
    }

    // 단게 5 : ConstraintLayout의 첫 인자로 ConstraintSet을 전달합니다.
    ConstraintLayout(
        constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {
        /*
        * 단계 3 : 'ConstraintLayout' 내에서 생성한 레퍼런스와 'constrainAs' 모디파이어를 삭제합니다.
        * val (redBox, magentaBox, greenBox, yellowBox) = createRefs()
        * */

        /*
        * 단계 4 : Box마다 'layoutId'를 설정합니다. 파라미터는 'ConstraintSet'에 만든 레퍼런스의 id로 적어줍니다.
        * */

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
        )

    }
}

// Ch04-05
@Composable
fun ConstraintLayoutEx2() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    start.linkTo(parent.start, margin = 18.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(parent.start, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start, margin = 20.dp)
                }
        )

        /*
        * 단계 1 : 'createVerticalChain', 'createHorizontalChain'을 이용해서 세 박스의 레퍼런스를 연결해봅시다.
        * */
        //createVerticalChain(redBox, yellowBox, magentaBox)
        //createHorizontalChain(redBox, yellowBox, magentaBox)


        /*
        * 단계 2 : 'createHorizontalChain'을 사용하고 'chainStyle' 키워드 파라미터를 추가합시다.
        * 'ChainStyle.Packed', 'ChainStyle.Spread', 'ChainStyle.SpreadInside' 등을 지정해봅시다.
        * */
        createVerticalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)
        /*
        * 단계 3 : 세 박스의 top을 parent.top에 연결하고 각각 다른 마진을 줍시다.
        * */
        val barrier = createEndBarrier(redBox, yellowBox, magentaBox)
        val topBarrier = createTopBarrier(redBox, yellowBox, magentaBox)

        /*
        * 단계 4 : 'createBottomBarrier'로 베리어를 만듭시다.
        * 이는 모든 박스들의 하단을 포함하는 베리어입니다.
        * */


        /*
        * 단계 5 : 'Text' 하나 만들고 top을 박스 베리어로 지정합니다.
        * */
        /*
        * 단계 6 : 체이닝 방향이나 베리어 방향을 바꾸어 보며 다양하게 테스트해봅시다.
        * */
        Text(
            text = "나라말슴이 듕귁에 달아 어린 백성이 나라말슴이 듕귁에 달아 어린 백성이 나라말슴이 듕귁에 달아 어린 백성이 나라말슴이 듕귁에 달아 어린 백성이 나라말슴이 듕귁에 달아 어린 백성이 ",
            modifier = Modifier
                .width(100.dp)
                .constrainAs(
                    text
                ) {
                    start.linkTo(barrier)
                    top.linkTo(yellowBox.bottom)
                }

        )

    }
}
