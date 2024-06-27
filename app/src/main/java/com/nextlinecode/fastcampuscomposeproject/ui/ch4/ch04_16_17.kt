package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/*
* 부수효과
* 1. LaunchedEffect : 컴포저블의 범위에서 정지 함수 실행
* 2. rememberCoroutineScope : 컴포지션 인식 범위를 확보하여 컴포저블 외부에서 코루틴 실행
* 3. rememberUpdatedState : 값이 변경되는 경우 다시 시작되지 않아야 하는 효과에서 값 참조
* 4. DisposableEffect : 정리가 필요한 효과
* 5. SideEffect : Compose 상태를 비 Compose 코드에 개시
* 6. produceState : 비 Compose 상태를 Compose 상태로 변환
* 7. derivedStateOf : 하나 이상의 상태 객체를 다른 상태로 변환
* 8. snapshotFlow : Compose의 상태를 Flow로 변환
* */

// ch04-16~17
@Composable
fun EffectEx(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    //val scaffoldState = rememberS

    /*
    * 단계 1 : 'LaunchedEffect`을 이용해서 스낵바를 이용해 봅시다.
    * 파라미터에는 `scaffoldState.snackbarHostState`를 전달합시다.
    * "헬로 컴포즈"라고 출력합시다.
    * `LaunchedEffect`는 `CoroutineScope`를 만들기 때문에 스코프를 별도로 만들 필요는 없습니다.
    * */

    /*
    * 단계 2 : `DisposableEffect`를 호출하고 파라미터로 `lifecycleOwner`를 전달합시다.
    *
    * `LifecycleEventObserver`를 상속받고 두 상타에 대해 로그를 남깁니다.
    * `Lifecycle.Event.ON_START`, `Lifecycle.Event.ON_STOP`
    * 블록 내에서 `lifecycleOwner.lifecycle.addObserver`로 옵저버를 추가하고
    * onDispose에서 옵저버를 제거합니다.
    * */
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(snackbarHostState) {
        snackbarHostState.showSnackbar("헬로 컴포즈. 패스트 캠퍼스")
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            // SAM : Single Abstract Method
            when (event) {
                Lifecycle.Event.ON_START -> {
                    Log.d("psm", "Effect_ON_START")
                }

                Lifecycle.Event.ON_STOP -> {
                    Log.d("psm", "Effect_ON_STOP")
                }

                Lifecycle.Event.ON_PAUSE -> {
                    Log.d("psm", "Effect_ON_PAUSE")
                }
                Lifecycle.Event.ON_RESUME -> {
                    Log.d("psm", "Effect_ON_RESUME")
                }

                else -> {
                    Log.d("psm", "Effect_Other")
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
//    Scaffold(
//        snackbarHost = { SnackbarHost(snackbarHostState) }
//    )
}