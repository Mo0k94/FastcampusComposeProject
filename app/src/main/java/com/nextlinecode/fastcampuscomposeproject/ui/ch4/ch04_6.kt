package com.nextlinecode.fastcampuscomposeproject.ui.ch4

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.nextlinecode.fastcampuscomposeproject.model.CardData


// Ch04-06
@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(4.dp)
            .height(100.dp) // 테스트용
    ) {
        /*
        * 단계 1 : 아래의 Row 레이아웃을 ConstrintLayout으로 바꾸어 봅시다.
        * */
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            val (profileImage, author, description) = createRefs()
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(color = placeHolderColor),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, 8.dp)
                        //linkTo(parent.top, parent.bottom)
                        /*top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)*/
                    }
            )
            Text(text = cardData.author,
                modifier = Modifier.constrainAs(author) {
                    //start.linkTo(profileImage.end, )
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints
                })

            Text(text = cardData.description,
                modifier = Modifier.constrainAs(description) {
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints
                })

            val chain = createVerticalChain(
                author,
                description,
                chainStyle = ChainStyle.Packed
            )

            constrain(chain) {
                top.linkTo(parent.top, margin = 8.dp)
                bottom.linkTo(parent.bottom, margin = 8.dp)
            }
        }
    }
}
