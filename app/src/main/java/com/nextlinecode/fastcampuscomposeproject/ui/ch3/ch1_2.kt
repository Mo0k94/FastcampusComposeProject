package com.nextlinecode.fastcampuscomposeproject.ui.ch3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nextlinecode.fastcampuscomposeproject.R


/*
* BoxWidthConstraints는 자주사용되지는 않는다.
* */
@Composable
fun Outer() {
    // 스탭 4 : Column에 width를 지정해서 제한해 봅시다.
    Column(modifier = Modifier.width(150.dp)) {
        /*
         * 스탭 2 : Inner의 인자로 Modifier.widthIn(min = 100.dp) 를 전달해봅시다.
         * heightIn도 전달해봅시다. 각각 인자의 max값도 전달해봅시다.
         */
        Inner(
            modifier = Modifier
                .width(200.dp)
                .height(160.dp)
        )
        Inner(
            modifier = Modifier
                .width(200.dp)
                .height(120.dp)
        )
    }
}

/*
* 스탭 1 : Inner 인자로 modifier를 전달해봅시다. 기본 값을 Modifier로 지정합시다.
* 파라미터로 받은 modifier를 BoxWithConstarins에 전달합시다.
* */
@Composable
private fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        // 스탭 3 : maxHeight 값이 150dp가 넘을 때만 추가로 텍스트를 출력해봅시다.
        if (maxHeight > 150.dp) {
            Text(
                text = "여기 꽤 길군요!!",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text("maxW:$maxWidth maxH: $maxHeight minW: $minWidth minH:$minHeight")
    }
}


@Composable
fun ImageGreeting() {
    Column {
        /*
        * 스탭 1 : Image를 만들어봅시다.
        * painter 항목에 painterResource (id = R.drawable.wall)
        * contentDescription에 엔텔로프 캐넌이라고 넣읍시다.
        * */
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "엔텔로프 캐넌"
        )

        /*
        * 스탭 2 : 두 번째 Image를 만들어봅시다.
        * ImageVector에 Icons.Filled.Search 설정해봅시다.
        * */
        Image(
            imageVector = Icons.Filled.Search,
            contentDescription = "검색"
        )

        /*
        * Bitmap 은 많이 사용되지 않고,
        * 순수한 컴포저블 함수 내에서 진행할 수가 없고, Context가 있는 액티비티 등에서 가지고 온
        * 다음에 여기에 주입을 시켜야 하기 때문
        *
        Image(
            bitmap =,
            contentDescription = ""
        )
        * */

    }
}


@Composable
fun CoilImageExample() {
    /*
    * 스탭 3 : rememberImagePainter를 이용해 Image의 painter를 설정합니다.
    * (Compose 한국어 문서의 추천, but Deprecated)
    * 이미지 URI : https://picsum.photos/seed/picsum/200/300
    * */

    /*val painter = rememberImagePainter(data = "https://fastly.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI")
    Image(
        painter = painter,
        contentDescription = "엔델로프 캐넌"
    )*/
    /*
    * 스탭 4 : AsyncImage
    * */
    Column {
        AsyncImage(
            model = "https://fastly.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI",
            contentDescription = "테스트이미지1"
        )
        AsyncImage(
            model = "https://fastly.picsum.photos/id/866/200/300.jpg?hmac=rcadCENKh4rD6MAp6V_ma-AyWv641M4iiOpe1RyFHeI",
            contentDescription = "테스트이미지2"
        )
    }
}