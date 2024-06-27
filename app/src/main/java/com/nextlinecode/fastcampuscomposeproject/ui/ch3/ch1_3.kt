@file:OptIn(ExperimentalMaterial3Api::class)

package com.nextlinecode.fastcampuscomposeproject.ui.ch3

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nextlinecode.fastcampuscomposeproject.model.CardData


@Composable
fun CardExample(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            /*
            * 스탭 1 : 'AsyncImage', 'Spacer', 'Column', 'Text' 로 레이아우승ㄹ 만들어보세요
            * */
            /*AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = cardData.description)
            }*/


            /*
            * 스탭 2 : 'AsyncImage' 에는 'placeHolder'를 지정하고,
            * 'contentScale'을 'ContentScale.Crop'으로 설정합시다.
            * 'clip(CircleShape)' 로 둥근 외양을 만들어 봅시다.
            * */
            AsyncImage(
                model = cardData.imageUri,
                contentScale = ContentScale.Crop,
                contentDescription = cardData.imageDescription,
                placeholder = ColorPainter(placeHolderColor),
                modifier = Modifier
                    .size(32.dp)
                    //.clip(RoundedCornerShape(5.dp))
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = cardData.description)
            }
        }
    }
}


@Composable
fun checkBoxExample() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        /*
        * 스탭 1 : CheckBox를 만들어봅시다. checked 속성은 false
        * onCheckedChange는 비워둡시다.
        * */
        //Checkbox(checked = false, onCheckedChange = {})

        /*
        * 스탭 2 : onChekcedChange에서 boolean 값 변수를 바꾸고
        * checked에서 그 값을 반영해봅시다. (잘 되지 않습니다.)
        * */
        /*var checked = false
        mutableStateOf(false)
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            }
        )*/
        /*
        * 스탭 3 : boolean 대신 remember { mutableStateOf(false) }를
        * 사용하여 상태를 도입합시다. (value 프로퍼티를 이용해야 합니다.)
        * */
        /*var checked = remember { mutableStateOf(false) }
        Checkbox(
            checked = checked.value,
            onCheckedChange = {
                checked.value = !checked.value
            }
        )*/
        /*
        위임된 속성
        var checked by remember { mutableStateOf(false) }
        checked가 프로퍼티인 것 처럼
        * 스탭 4 : delegated properties로 변경해봅시다.
        * */
        /*var checked by remember {mutableStateOf(false) }
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            }
        )*/

        /*
        * 스탭 5 : destruction으로 상태를 받아서 사용해봅시다.
        * */
        val (getter, setter) = remember { mutableStateOf(false) }
        Checkbox(
            checked = getter,
            onCheckedChange = setter
        )

        // CheckBox를 앞에 넣어주세요.
        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                setter(!getter)
            }
        )


    }
}

@Composable
fun TextFieldExample() {

    var name by remember { mutableStateOf("Tom") }

    Column(modifier = Modifier.padding(16.dp)) {
        /*
        * 스탭 1 : TextField를 Text위에 만듭니다.
        * value와 onValueChanged는 비워둡시다.
        * TextField(value = "Tom", onValueChange = {})
        * */

        /*
        * 스탭 2 : Text에 Android 대신 TextField 입력을 출력하게 합시다.
        * mutableStateOf("") 필드를 하나 만듭시다.
        * */

        /*
        * 스탭 3 : TextFiled에 label을 추가합시다.
        * 내용에는 "Text("Name")을 채워봅시다.
        * */
        /*TextField(
            label = {
                Text("이름")
            },
            value = name,
            onValueChange = {
                name = it
            }
        )*/

        /*
        * 스탭 4 : TextFiled와 Text 사이에 Spacer를 넣어 8.dp 간격을 줍시다.
        * */

        /*TextField(
            value = name,
            label = {
                Text("이름")
            },
            onValueChange = { name = it }
        )*/

        //Spacer(modifier = Modifier.size(8.dp))

        // 스탭 5 : TextField를 OutlinedTextField로 변경해봅시다.

        OutlinedTextField(
            value = name,
            label = {
                Text("이름")
            },
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = "Hello $name")
    }
}

@Composable
fun TopBarExample(name: String) {
    Column {
        // 스탭 1 : TopAppBar를 만들고 title 항목을 채워봅시다.
        /*TopAppBar(title = {
            Text("TopAppBar")
        })*/

        /*
        * 스탭 2 : navigationIcon 파라미터를 채워봅시다.
        * IconButton을 만들고 자식으로 Icon을 넣읍시다.
        * 아이콘은 Icons.Filled.ArrowBack을 채웁시다.
        * onClick은 비워둡시다.
        * */
        /*TopAppBar(title = {
                    Text("TopAppBar")
                },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "업 네비게이션")
                }
            }
        )*/
        /*
        * 스탭 3 : actions를 추가해봅시다.
        * Icons.Filled의 여러 아이콘을 이용해봅시다.
        * */
        /*TopAppBar(title = {
            Text("TopAppBar")
        },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )*/
        // 스탭 4 : TopAppBar content 파라미터 버전을 만들어봅시다.
        /*TopAppBar {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "업 네비게이션"
                )
            }
            Text("TopAppBar")
        }*/

        TopAppBar(title = {
            Text("TopAppBar", modifier = Modifier.weight(1f))
        },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )
        Text(text = "Hello $name")
    }
}

/*
* 스탭 1 : 'Row'를 '@Composable' 함수로 분리합시다.
* 'checked'의 값, 'Text'의 'text'를 인자로 전달합시다.
* */

/*@Composable
fun CheckBoxWithText(checked: MutableState<Boolean>, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        Text(
            text = text,
            modifier = Modifier.clickable { checked.value = !checked.value }
        )
    }
}*/
/*
* 스탭 2 : `@Composable` 함수에서 `@Composable () -> Unit` 타입으로
* `content`를 받아옵시다. 'Row'의 'Text'를 빼고 'content()'를 넣읍시다.
* 'Row'에 'Modifier.clickable'를 넣어 전체를 클릭가능하게 합시다.
* */
/*@Composable
fun CheckboxWithSlot(
    checked: MutableState<Boolean>,
    content: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            checked.value = !checked.value
        }
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        content()
    }
}*/

/*
* 스탭 3 : 'content'의 타입을 '@Composable RowScape.() -> Unit' 으로 바꿉시다.
* 이렇게 다른 컴포저블 컨텐트를 넣는 방식을 Slot API라 합니다.
* */
/*@Composable
fun CheckboxWithSlot(
    checked: MutableState<Boolean>,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            checked.value = !checked.value
        }
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        content()
    }
}*/
/*
* 스탭 4 : 상태를 바꾸는 람다를 '@Composable' 함수의 인자로 뺍시다.
* 인자에서 MutableState대신 boolean 값으로 변경합시다.
* */
@Composable
fun CheckboxWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }
}

@Composable
fun SlotExample() {


    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
        /*Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked1.value,
                onCheckedChange = { checked1.value = it }
            )
            Text(
                text = "텍스트 1",
                modifier = Modifier.clickable { checked1.value = !checked1.value }
            )
        }*/


        /*Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked2.value,
                onCheckedChange = { checked2.value = it }
            )
            Text(
                text = "텍스트 2",
                modifier = Modifier.clickable { checked2.value = !checked2.value }
            )
        }*/
        //CheckBoxWithText(checked = checked1, text = "텍스트1")
        //CheckBoxWithText(checked = checked2, text = "텍스트2")
        /*CheckboxWithSlot(checked = checked1) {
            Text("텍스트 1", modifier = Modifier.align(Alignment.CenterVertically))
        }
        CheckboxWithSlot(checked = checked2) {
            Text("텍스트 2")
        }*/

        CheckboxWithSlot(checked = checked1,
            onCheckedChanged = {
                checked1 = !checked1
            }) {
            Text("텍스트 1", modifier = Modifier.align(Alignment.CenterVertically))
        }
        CheckboxWithSlot(checked = checked2, onCheckedChanged = {
            checked2 = !checked2
        }) {
            Text("텍스트 2")
        }

    }
}

@Composable
fun CheckBoxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { toggleState() },
        )
        content()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    var checked by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            // 스탭 1 : 'topBar'를 'TopAppBar'로 채워 봅시다.
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로 가기"
                        )
                    }
                },
                title = {
                    Text(text = "Scaffold App")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {

            }
        }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Hello it`s main text")
            Text("Welcome to Composable world")
        }
//        Surface(modifier = Modifier.padding(8.dp)) {
//            // 스탭 2 : 아래에 CheckBoxWithContent를 넣어봅시다.
//            CheckBoxWithContent(
//                checked = checked,
//                toggleState = { checked = !checked}
//            ) {
//                Text(text="컴포즈를 좋아합니다.")
//            }
//        }
    }
}