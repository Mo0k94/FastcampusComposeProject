package com.nextlinecode.fastcampuscomposeproject.ui.ch3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nextlinecode.fastcampuscomposeproject.R
import com.nextlinecode.fastcampuscomposeproject.ui.theme.FastcampusComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FastcampusComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ){
                    CatalogEx(items)
                }
            }
        }
    }

}

@Composable
fun Item(itemData: ItemData) {
    // 스탭 1 : catalog1.png를 참고해 카드 레이아웃을 완성하세요.
    Card(
        //elevation = CardElevation = 8.dp,
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // 이미지
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = itemData.title
            )
            // 공백
            Spacer(modifier = Modifier.size(8.dp))

            // 타이틀
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.headlineLarge
            )

            // 공백
            Spacer(
                modifier = Modifier.size(8.dp)
            )

            // 설명
            Text(
                text = itemData.description
            )
        }
    }
}

@Composable
fun CatalogEx(itemList: List<ItemData>) {


    /*
    Horizontal List
    LazyRow {
        items(itemList) {item ->
            Item(item)
        }
    }
    */
    /*
    Vertical List
    */
    LazyColumn {
        /*
        *   스탭 2 : items(itemList) 를 이용해 item을 반복해서 컬럼에 추가하세요.
        * */
        // 헤더 영역을 따로 구성하고 싶을때는 item으로 설정가능
        item{
            Item(itemList[0])
        }

        items(itemList) { item ->
            Item(item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FastcampusComposeProjectTheme {
        CatalogEx(itemList = items)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    FastcampusComposeProjectTheme {
        Item(
            ItemData(
                imageId = R.drawable.a1,
                title = "해변 놀이 공원",
                description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
            )
        )
    }
}


val items = listOf(
    ItemData(
        imageId = R.drawable.a1,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a2,
        title = "캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    )
)

data class ItemData(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String
)
