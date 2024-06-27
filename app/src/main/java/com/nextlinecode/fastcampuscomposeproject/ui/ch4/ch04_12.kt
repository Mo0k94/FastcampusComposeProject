package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

// ch04-12
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarEx() {
    //val scaffoldState =
    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()
    var counter by remember {
        mutableStateOf(0)
    }
    /*LaunchedEffect(snackbarHostState) {
        snackbarHostState.showSnackbar("")
    }*/
    // 단계 1 : "Scaffolld"에 "scaffoldState"를 설정합시다.
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            BottomAppBar() {
                Text("헬로")
                Button(onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "안녕하세요"
                        )
                    }
                }) {
                    Text("인사하기")
                }
                Button(onClick = {
                    counter++
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("${counter}입니다.")
                    }
                }) {
                    Text("더하기")
                }
                Button(onClick = {
                    counter--
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("${counter}입니다.")
                    }
                }) {
                    Text("빼기")
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "카운터는 ${counter}회입니다.",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
    /*
    * 단계 2 : "bottomBar" 파라미터에 "BottomAppBar"를 넣읍시다.
    * 내용은 텍스트와 버튼을 넣어 봅시다. 버튼에는 "snackBar"를 연동해 메시지를 출력합니다.
    * */
}