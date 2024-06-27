package com.nextlinecode.fastcampuscomposeproject.ui.ch05

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nextlinecode.fastcampuscomposeproject.ui.ch4.TodoData

/*
* ch04_18.kt 와 이어서 작업한다.
* */

/*
* ch05_02 단계 2 : ViewModel 을 상속받은 TodoViewModel을 만듭니다.
* 첫 단계에서는 내용을 비워두고 시작합시다.
* */

class TodoViewModel: ViewModel() {

    /*
    * ch05_03 단계 2 : text 상태를 라이브 데이터로 변경합니다.
    * 사용하는 측에서는 text.observeAsState()로 구독하세요.
    * val text = mutableStateOf("")
    * */
    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text
    val setText: (String) -> Unit = {
        _text.value = it
    }

    /*
    * ch05_03 단계 3 : toDoList 상태를 라이브 데이터로 변경합니다.
    * 모든 연산에서 List를 새로 만들어 라이브 데이터로 전달해야 합니다!
    * (초 비추!!)
    * */

    // mutableStateListOf - 추가, 삭제, 대입 -> UI 가 갱신이 된다.각 항목의 필드가 바뀌었을 때 -> 갱신이 안되는 문제
    // LiveData<List<X>>.observeAsState() - List가 통채로 다른 List로 바뀌엇을 때만 State가 갱신된다.
    //val toDoList = mutableStateListOf<TodoData>()

    private val _rawToDoList = mutableListOf<TodoData>()
    private val _toDoList = MutableLiveData<List<TodoData>>(_rawToDoList)
    val toDoList: LiveData<List<TodoData>> = _toDoList

    val onSubmit: (String) -> Unit = {
        val key = (_rawToDoList.lastOrNull()?.key ?: 0) + 1
        _rawToDoList.add(TodoData(key, it))

        /*
        * 복사하는 방법
        * 1. ArrayList<TodoData>(_rawToDoList)
        * 2. mutableListOf<TodoData>().also{ list ->
            list.addAll(_rawToDoList)
        * } // shallow copy가 발생할 수 있다.
        * 3. _rawToDoList.toMutableList()
        * */
        _toDoList.value = mutableListOf<TodoData>().also { list ->
            list.addAll(_rawToDoList)

        }
        _text.value = ""
    }

    val onToggle: (Int, Boolean) -> Unit = {key, checked ->
        val i = _rawToDoList.indexOfFirst {
            it.key == key
        }
        _rawToDoList[i] = _rawToDoList[i].copy(done = checked)
        _toDoList.value = mutableListOf<TodoData>().also {
            it.addAll(_rawToDoList)
        }
    }

    val onDelete: (Int) -> Unit = { key ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList.removeAt(i)
        _toDoList.value = mutableListOf<TodoData>().also {
            it.addAll(_rawToDoList)
        }
    }

    val onEdit: (Int, String) -> Unit = {key, newText ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList[i] = _rawToDoList[i].copy(text = newText)
        _toDoList.value = mutableListOf<TodoData>().also {
            it.addAll(_rawToDoList)
        }
    }

}

