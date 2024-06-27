package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch

// ch04-11
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SnackbarEx() {

    /*
    * Snackbar()를 직접 사용하기에는 애니메이션, 화면 배치, 디스미스 처리 등 모두 직접 처리해야 하므로,
    * SnackbarHost()를 사용하는게 좋다.
    * */
    var counter by remember { mutableStateOf(0) }

    /*
    * 단계 3 : couroutineScope를 만듭시다.
    * "rememberCoroutineScope"를 사용합시다.
    * */

    /*
    *   단계1 : scaffoldState를 만들고 Scaffold에 설정합시다.
    * scaffoldState를 만들기 위해 "rememberScaffoldState"를 사용합시다.
    * */
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        /*
        * 단계 2 : "더하기" 버튼을 만들어 봅시다.
        * action에서 counter를 증가시킵시다.
        * */
        Button(onClick = {
            counter++
            scope.launch {
                val result = snackbarHostState.showSnackbar(
                    message = "카운터는 ${counter}입니다.",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )
                when (result) {
                    SnackbarResult.Dismissed -> {}
                    SnackbarResult.ActionPerformed -> {}
                    else -> {}
                }
            }
        }) {
            Text("더하기")
        }
        // 단계  4: 버튼의 onClick에서 "coroutineScope.launch"를 사용합시다.

        /*
        * 단계 5 : 스낵바를 사용하기 위해 "scaffoldState.snackbarHostState.showSnackbar" 사용합시다.
        * */

        /*
                        * "message"에 카운터를 출력합시다.
                        * "actionLabel" 를 "닫기"로 지정합시다.
                        * "duration" 에 "SnackbarDuration.Short"를 사용합시다.
                        * */

    }
}
