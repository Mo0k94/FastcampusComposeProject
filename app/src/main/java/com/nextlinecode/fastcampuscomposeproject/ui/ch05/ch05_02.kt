package com.nextlinecode.fastcampuscomposeproject.ui.ch05

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nextlinecode.fastcampuscomposeproject.ui.ch4.TodoData

/*
* ch04_18.kt 와 이어서 작업한다.
* */

/*
* 단계 2 : ViewModel 을 상속받은 TodoViewModel을 만듭니다.
* 첫 단계에서는 내용을 비워두고 시작합시다.
* */

class TodoViewModel: ViewModel() {

    val text = mutableStateOf("")

    val toDoList = mutableStateListOf<TodoData>()

    val onSubmit: (String) -> Unit = {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(TodoData(key, it))
        text.value = ""
    }

    val onToggle: (Int, Boolean) -> Unit = {key, checked ->
        val i = toDoList.indexOfFirst {
            it.key == key
        }
        toDoList[i] = toDoList[i].copy(done = checked)
    }

    val onDelete: (Int) -> Unit = { key ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList.removeAt(i)
    }

    val onEdit: (Int, String) -> Unit = {key, text ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(text = text)
    }

}

