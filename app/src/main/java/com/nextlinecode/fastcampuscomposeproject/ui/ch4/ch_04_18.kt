package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nextlinecode.fastcampuscomposeproject.ui.ch05.TodoViewModel
import com.nextlinecode.fastcampuscomposeproject.ui.theme.FastcampusComposeProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}


/*
* 단계 3 : TopLevel 의 파라미터로 TodoViewModel 타입의
* viewModel을 전달합니다. 기본 값은 viewModel() 로 설정합시다.
* 에러가 발생하면 아래의 import 문을 추가합니다.
* import androidx.lifecycle.viewmodel.compose.viewModel
* */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopLevel(viewModel: TodoViewModel = viewModel()) {

    /*
    * 단계 4 : text, setText를 뷰 모델로 옮겨봅시다.
    * 뷰 모델의 프로퍼티로 변경할 경우에는 destrunction (비구조화, 구조 분해)는 사용할
    * 수 없으니 by 를 써봅시다.
    * remember는 제거해야 합니다.
    * //val (text, setText) = remember { mutableStateOf("") }
    * */

    /*
    * 단계 5 : toDoList, onSubmit, onEdit, onToggle, onDelete를 모두
    * 뷰 모델로 옮겨봅시다.
    *
    * val toDoList = remember { mutableStateListOf<TodoData>() }
//    val onSubmit: (String) -> Unit = {
//        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
//        toDoList.add(TodoData(key, it))
//        viewModel.text.value = ""
//    }
//
//    val onToggle: (Int, Boolean) -> Unit = {key, checked ->
//        val i = toDoList.indexOfFirst {
//            it.key == key
//        }
//        toDoList[i] = toDoList[i].copy(done = checked)
//    }
//
//    val onDelete: (Int) -> Unit = { key ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList.removeAt(i)
//    }
//
//    val onEdit: (Int, String) -> Unit = {key, text ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList[i] = toDoList[i].copy(text = text)
//    }
    * */


    /*
    * MutableStateList가 추가, 삭제, 변경되었을 때만 UI 갱신
    * 항목 하나의 값을 바꾸는 것 보다 항목 자체를 바꾸는께 효율적
    * */


    /*
    * 단계 4 : `onSubmit`, `onEdit`, `onToggle`, `onDelete`를 만들어
    * `TODO`에 연결합니다.
    * */
    Scaffold{
        Column {
            TodoInput(
                text = viewModel.text.value,
                onTextChange = {
                    viewModel.text.value = it
                },
                onSubmit = viewModel.onSubmit)
            /*
            * 단계 3 : `LazyColumn`으로 `toDoList`를 표시합시다.
            * `key`를 `toDoData`의 `key`를 사용합니다.
            * */
            LazyColumn {
                items(viewModel.toDoList, key = { it.key }) { todoData ->
                    Todo(
                        todoData = todoData,
                        onEdit = viewModel.onEdit,
                        onToggle = viewModel.onToggle,
                        onDelete = viewModel.onDelete)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Todo(
    todoData: TodoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        /*
        * 단계 1 : `Row`를 만들고 `toDoData.text`를 출력하고
        * 완료를 체크하는 체크박스, 수정 버튼, 삭제 버튼을 만드세요.
        * */

//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = todoData.text,
//                modifier = Modifier.weight(1f)
//            )
//            Text(
//                text = "완료"
//            )
//            Checkbox(
//                checked = todoData.done,
//                onCheckedChange = { checked ->
//                    onToggle(todoData.key, checked)
//                }
//            )
//            Button(onClick = {}){
//                Text("수정")
//            }
//            Spacer(modifier = Modifier.size(4.dp))
//            Button(onClick = {}) {
//                Text("삭제")
//            }
//        }

        /*
        * 단계 2 : `Crossfade`를 통해 `isEditing`을 따라 다른
        * UI를 보여줍니다. `OutlinedTextField`와 `Button`을 넣어봅시다.
        * */
        Crossfade(targetState = isEditing) {
            when (it) {
                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = todoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "완료"
                        )
                        Checkbox(
                            checked = todoData.done,
                            onCheckedChange = { checked ->
                                onToggle(todoData.key, checked)
                            }
                        )
                        Button(onClick = {
                            isEditing = true
                        }) {
                            Text("수정")
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onDelete(todoData.key)
                        }) {
                            Text("삭제")
                        }
                    }
                }
                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        var (newText, setNewText) = remember { mutableStateOf(todoData.text) }
                        OutlinedTextField(
                            value = newText,
                            onValueChange = setNewText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onEdit(todoData.key, newText)
                            isEditing = false
                        }) {
                            Text("완료")
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TodoPreview() {
    FastcampusComposeProjectTheme {
        Todo(TodoData(1, "nice", true))
    }
}

/*
*
*
* */
data class TodoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)