package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


// Ch04-08
@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text("다이얼로그 열기")
        }
        Text("카운터 : $counter")
    }
    if (openDialog) {
        AlertDialog(onDismissRequest = {
            // 단계 1 : 'openDialog'를 이용해 다이얼로그를 끌 수 있게 합니다.
            openDialog = false
        }, confirmButton = {
            // 단계2 : "더하기" 버튼을 만들고 'counter' 를 증가시키고, 다이얼로그도 끕니다.
            Button(onClick = {
                counter++
                openDialog = false
            }) {
                Text(text = "더하기")
            }
        }, dismissButton = {
            // 단계 3 : "취소" 버튼을 만들고 다이얼로그를 끕니다.
            Button(onClick = {
                openDialog = false
            }) {
                Text("취소")
            }
        }, title = {
            // 단계 4 : 타이틀을 만듭니다. "더하기" 정도로 해봅시다.
            Text("더하기")
        }, text = {
            // 단계 5 : 다이얼로그에서 설명할 문구를 출력합니다.
            Text("더하기 버튼을 누르면 카운터를 증가합니다.\n버튼을 눌러주세요.")
        })
    }
}

// ch04-09
@Composable
fun CustomDialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = {
            openDialog = true
        }) {
            Text("다이얼로그 열기")
        }
        Text("카운터 : $counter")
    }

    if (openDialog) {
        Dialog(onDismissRequest = {
            // 단계 1 : dismiss 처리를 합니다.
            openDialog = false
        }) {
            Surface {
                // 단계 2 : 컬럼을 만들고 설명을 적어봅시다.
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("버튼을 클릭해주세요.\n* +1을 누르면 값이 증가됩니다.\n* -1을 누르면 값이 감소됩니다.")

                    /*
                    * 단계 3 : 컬럼 안에 로우를 만들어 수평 방향으로 버튼을 배열합니다.
                    * 버튼은 +1, -1, 취소로 구성하겠습니다.
                    * +1은 counter를 증가시키고, -1은 counter를 감소, 취소는 다이얼로그를 닫습니다.
                    * */
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 12.dp)
                    ) {
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text("취소")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter++
                        }) {
                            Text("+1")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter--
                        }) {
                            Text("-1")
                        }

                    }
                }


            }
        }
    }
}
