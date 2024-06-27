package com.nextlinecode.fastcampuscomposeproject.ui.ch3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Greeting(name: String) {

    // 스텝 1 : 색상을 지정하기 위해 color 파라미터에 color.Red를 전달해봅시다.
    // Text(color = Color.Red, text = "Hello $name")
    // 스탭 2 : Color 객체를 이용해서 해쉬값으로 색상을 전달해봅시다. (ARGB 순)
    // Text(color = Color(0xffff9944), text = "Hello $name")
    // 스탭 3 : fontSize 파라미터에 30.sp를 전달해봅시다.
    //Text(color = Color.Red, text= "Hello $name", fontSize = 30.sp)
    // 스탭 4 : fontWeight에 FontWeight.Bold를 전달해봅시다.
    //Text(color = Color.Red, text= "Hello $name", fontSize = 30.sp, fontWeight = FontWeight.Bold)
    // 스탭 5 : fontFamily에 FontFamily.Cursive 전달해봅시다.
//    Text(
//        color = Color.Red,
//        text = "Hello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive
//    )
    // 스탭 6 : letterSpacing에 2.sp를 지정해봅시다.
//        Text(
//        color = Color.Red,
//        text = "Hello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//            letterSpacing = 2.sp
//    )
    // 스탭 7 : maxLine를 2로 지정하고 문자열을 더 추가해봆디ㅏ.
//    Text(
//        color = Color.Red,
//        text = "Hello $name\nHello $name\nHello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        maxLines = 2,
//    )
    // 스탭 8 : textDecoration에 TextDecoration.UnderLine을 추가합시다.
//    Text(
//        color = Color.Red,
//        text = "Hello $name\nHello $name\nHello $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        maxLines = 2,
//        textDecoration = TextDecoration.Underline
//    )
    // 스탭 9 : textAlign을 TextAlign.Center로 지정합니다.
    // modifier = Modifier.width(200.dp)나
    // modifier = Modifier.size(200.dp)를 설정해서 충분히 넓혀둡니다.
    Text(
        //modifier = Modifier.width(300.dp),
        modifier = Modifier.size(300.dp),
        color = Color.Red,
        text = "Hello $name\nHello $name\nHello $name",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )
}


@Composable
fun ButtonExample(onButtonClicked: () -> Unit, name: String) {
    /*Button(onClick = onButtonClicked) {
        Text(text = "Send $name")
    }*/
    // 스탭 1 : Button을 클릭했을 때 Toast를 출력하게 만들어보기

    // 스탭 2 : Icon을 Text 앞에 추가시켜보기.
    // ImageVector에는 Icons.Filled.Send를 넣고
    // contentDescription에는 null을 넣어봅시다.
//    Button(onClick = onButtonClicked) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = "Send"
//        )
//        Text(text = "Send $name")
//    }

    /*
    스탭 3 : 아이콘과 텍스트 사이에 Spacer를 넣어보기
    * modifier에 Modifier.size를 넣고 사이즈를
    * ButtonDefaults.IconSpacing을 지정합시다.
    * */
//    Button(onClick = onButtonClicked) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send $name")
//    }
    // 스탭 4 : enabled를 false로 바꾸어봅시다.
//    Button(
//        onClick = onButtonClicked,
//        enabled = false) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send $name")
//    }
    // 스탭 5 : border에 BorderStroke를 설정합시다.
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(5.dp, Color.Magenta)
//
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send $name")
//    }
    // 스탭 6 : shape를 CircleShape로 지정합시다.
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(5.dp, Color.Magenta),
//        shape = RoundedCornerShape(10.dp, 20.dp, 30.dp, 40.dp)
//
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send $name")
//    }
    // 스탭 7 : contentPadding에 PaddingValues를 설정합시다.
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(10.dp, Color.Magenta),
        contentPadding = PaddingValues(20.dp)

    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send $name")
    }
}

@Composable
fun ModifierExample() {

    /*Button(onClick = {}) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search")
    }*/
    // 스탭 1 : modifier에 Modifier.fillMaxSize()를 사용해봅시다.
    /*Button(
        onClick = {},
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search")
    }*/
    // 스탭 2 : fillMaxSize 대신 Modifier.height를 설정해봅시다.
    /*Button(
        onClick = {},
        modifier = Modifier.height(100.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search")
    }*/
    // 스탭 3 : modifier에 height와 width를 같이 설정해봅시다.
    /*Button(
        onClick = {},
        modifier = Modifier.height(100.dp)
            .width(200.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search")
    }*/
    // 스탭 4 : size에 width와 height를 인자로 넣을 수도 있습니다.
    /*Button(
        onClick = {},
        modifier = Modifier
            .size(200.dp, 60.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search")
    }*/
    /*
    * 스탭 5 : background를 설정해봅시다. (버튼에서는 되지 않음.)
    * Button에 되지 않으면 Text나 Icon에 지정해봅시다.
    * */
    /*Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 60.dp)
                .background(Color.Red)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text("Search")
        }*/
    /*
    * 스탭 6 : colors 파라미터에 ButtonDefaults.buttonColors를
    * 넣어보세요. backgroundColor와 contentColor 프로퍼티를 설정하세요.
    * */
    /*Button(
        colors = ButtonDefaults.buttonColors(contentColor = Color.Cyan),
        onClick = {},
        modifier = Modifier
            .size(200.dp, 60.dp)
            .background(Color.Red)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search")
    }*/
    // 스탭 7 : Button의 modifier에 padding을 추가해봅시다.
    /*Button(
        colors = ButtonDefaults.buttonColors(contentColor = Color.Cyan),
        onClick = {},
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search")
    }*/
    /*
    *  스탭 8 : Button에 enabled를 false로 설정하고, Text의
    * modifier에 clickable를 넣어봅시다.
    * */
    /*Button(
        colors = ButtonDefaults.buttonColors(contentColor = Color.Cyan),
        onClick = {},
        enabled = false,
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text("Search",
        modifier = Modifier.clickable{})
    }*/
    // 스탭 9 : Text의 modifier에 offset를 설정하고 x 파라미터를 설정합시다.
    Button(
        colors = ButtonDefaults.buttonColors(contentColor = Color.Cyan),
        onClick = {},
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier
                .size(ButtonDefaults.IconSpacing)
                .background(Color.Red)
        )
        Text(
            "Search",
            modifier = Modifier
                .offset(x = 10.dp, y = 10.dp)
                .background(Color.Green)
        )
    }
    //

}

@Composable
fun SurfaceGreeting(name: String) {
    /*Surface(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }*/

    // 스탭 1 : Surface에 elavation을 설정합시다.

    /*Surface(
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp

    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }*/
    // 스탭 2 : border의 값을 설정해봅시다.
    /*Surface(
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 5.dp
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }*/
    // 스탭 3 : Surface의 shape도 설정해봅시다.
    /*Surface(
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 10.dp,
        shape = CircleShape
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }*/
    /*
    * 스탭 4 : color를 지정합시다.
    * MaterialTheme.colors에서 primary, error, background, surface, secondary 등을 지정해봅시다.
    * contentColor가 자동으로 선택됩니다.
    * */
    Surface(
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 10.dp,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.error
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }
}


@Composable
fun BoxExample() {

    /*
    * FrameLayout와 같이 레이아웃을 중첩시킬떄 사용
    * 마지막에 추가한 뷰가 가장 바깥에 배치
    * */
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
//        Text(text = "Jetpack Compose", modifier = Modifier.align(Alignment.CenterEnd))
//        Text(text = "Jetpack Compose", modifier = Modifier.align(Alignment.CenterEnd))
//    }

    // 스탭 1 : Text 두개를 Box 안에 배치해봅시다.
    /*Box(modifier = Modifier.size(100.dp)) {
        Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "Jetpack", modifier = Modifier.align(Alignment.CenterEnd))
        Text(text = "Compose", modifier = Modifier.align(Alignment.TopStart))
    }*/
    // 스탭 2 : 2개의 Box를 Box 안에 배치하고, 사이즈를 70dp, 색상을 각기 다르게 해봅시다.
    /*Box(modifier = Modifier.size(100.dp)) {
        Box(modifier = Modifier.size(70.dp).background(Color.Cyan).align(Alignment.CenterStart))
        Box(modifier = Modifier.size(70.dp).background(Color.Yellow).align(Alignment.BottomEnd))
        }*/
    /*
       스탭 3 : 부모 Box에 modifier 설정을 제거해서 콘텐트 사이즈만큼 보여주게 합시다.
       그리고 첫번째 자식 Box의 사이즈를 matchParentSize()로 설정해봅시다.
       다음에는 fillMaxSize()로 설정해봅시다.
    */

    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .align(Alignment.CenterStart)
        )
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Yellow)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun RowExample() {
    /*Row(modifier = Modifier.height(40.dp)) {
        Text(text = "첫 번째!")
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }*/

    /*
    * 스탭 1 : 각 Text의 modifier에 align을 설정합시다.
    * AAlignment.Top, CenterVertically, Bottom을 지정해봅시다.
    * */
    /*Row(modifier = Modifier.height(40.dp)) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
            Text(text = "두 번째!", modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = "세 번째!", modifier = Modifier.align(Alignment.Bottom))
        }*/
    /*
    * 스탭 2 : Row에 verticalAlignment를 설정해봅시다.
    * Text에 align을 사용할 떄와 쓰이는 값이 같습니다.
    * */
    /*Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.height(40.dp)
    ) {
        Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }*/
    /*
    * 스탭 3 : Row의 height를 200dp 정도로 설정합시다.
    * Row에 horizontalArrangement에 Arrangement.Center를
    * 설정해봅시다. Start, End, SpaceAround, SpaceBotween SpaceEvenly를 설정해봅시다.
    * */

    /*Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.height(40.dp).width(200.dp)
    ) {
        Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }*/

    /*
    *   스탭 4 : horizontalArrangement를 제거하고 각 Text에 Modifier.weight를 설정합시다.
    * 각 항목의 weight 값을 바꾸어 보세요.
    * */
    /*Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .height(40.dp)
    ) {
        Text(text = "첫 번째!", modifier = Modifier.weight(1f))
        Text(text = "두 번째!", modifier = Modifier.weight(2f))
        Text(text = "세 번째!", modifier = Modifier.weight(1f))
    }*/

    // 스탭 5 : Text 대신 Icon을 하나 넣어봅시다.
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .height(40.dp)
    ) {
        Text(
            text = "두 번째!",
            textAlign = TextAlign.Center, modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "계정",
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
        )
        Text(
            text = "세 번째!",
            textAlign = TextAlign.End,
            modifier = Modifier
                .weight(1f)
                .background(Color.Blue)
        )
    }
}

@Composable
fun ColumnExample() {
    /*Column(modifier = Modifier.size(100.dp)) {
        Text(text = "첫 번쨰")
        Text(text = "두 번쨰")
        Text(text = "세 번쨰")
    }*/

    // 스탭 1 : horizontalAlignment를 Column에 적용해봅시다.
    /*Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(100.dp)
    ) {
        Text(text = "첫 번쨰")
        Text(text = "두 번쨰")
        Text(text = "세 번쨰")
    }*/
    /*
    *  스탭 2 : Column에 verticalArrangement를 지정해봅시다.
    * SpaceAround, SpaceEvenly, SpaceBetween도 해봅시다.
    * */
    /*Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(100.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(text = "첫 번쨰")
        Text(text = "두 번쨰")
        Text(text = "세 번쨰")
    }*/
    // 스탭 3 : Text에 Modifier.align을 사용해 봅시다.
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.size(100.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "첫 번쨰",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "두 번쨰")
        Text(
            text = "세 번쨰",
            modifier = Modifier.align(Alignment.Start))
    }
}