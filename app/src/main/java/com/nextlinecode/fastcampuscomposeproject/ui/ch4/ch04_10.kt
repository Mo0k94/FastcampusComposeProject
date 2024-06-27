package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// ch04-10
@Composable
fun DropDownMenuEx() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = true }) {
            Text("드롭다운 메뉴 열기")
        }
        Text("카운터 : $counter")
    }

    /*
    * 단계 1 : DropDownMenu를 만들고 "expanded"를 "expandDropDownMenu"로 등록합시다.
    * onDismissRequest 에 대해서는 expandDropDownMenu를 false로 바꿉니다.
    * */
    DropdownMenu(
        expanded = expandDropDownMenu,
        onDismissRequest = {
            expandDropDownMenu = false
        }
    ) {
        /*
        * 단계 2 : 두개의 "DropDownMenuItem" 을 등록합시다.
        * onCLick을 구현하고 내용물은 "Text"로 채워봅시다.
        * */
        DropdownMenuItem(
            text = { Text(text = "증가") },
            onClick = { counter++ }
        )
        DropdownMenuItem(
            text = { Text("감소") },
            onClick = { counter-- }
        )
    }
}