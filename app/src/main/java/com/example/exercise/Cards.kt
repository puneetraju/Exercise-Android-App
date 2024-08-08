package com.example.exercise

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercise.model.DataSets.exes
import com.example.exercise.model.KuchBhi
import com.example.exercise.ui.theme.Exercise

@Composable
fun ActualApp(){
    Scaffold(
        topBar = { HeadingTopBar()},
        containerColor = MaterialTheme.colorScheme.background
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(exes){
                DayCard(
                    dataC = it,
                    modifier = Modifier)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeadingTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Text(text = stringResource(id = R.string.Title_Head),
            style = MaterialTheme.typography.displayLarge)
    },modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.secondaryContainer))
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayCard(dataC: KuchBhi, modifier: Modifier

){
    var clickIt by remember { mutableStateOf(false)}
    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(12.dp),
        border = BorderStroke(width = 2.dp, brush = SolidColor( MaterialTheme.colorScheme.tertiary)),
        onClick = { clickIt = !clickIt}
        ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CardTitle(title = dataC.TitleRes, modifier = modifier)
            CardPic(img = dataC.ImgRes)
            CardDesc(desc = dataC.DatasetRes, modifier = modifier)
            if(clickIt){
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = stringResource(id =R.string.How_to),style = MaterialTheme.typography.displayMedium)
                CardRep(procedure = dataC.DesRes)
            }

        }
    }

}



@Composable
fun CardPic(
    @DrawableRes img : Int
){
    Image(
        painter = painterResource(img),
        contentDescription = null,
        modifier = Modifier
            .size(width = 300.dp, height = 250.dp)
            .padding(top = 20.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.FillBounds,


    )
}

@Composable
fun CardTitle(
    @StringRes title: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(title),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}

@Composable
fun CardDesc(
    @StringRes desc : Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(desc),
        style = MaterialTheme.typography.displayMedium,
        modifier = modifier
    )
}
@Composable
fun CardRep(
    @StringRes procedure: Int,
){
    Text(
        text = stringResource(procedure),
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewT(){
    Exercise(darkTheme = false) {
//        DayCard(dataC = KuchBhi(
//            TitleRes = R.string.title_1 ,
//            ImgRes = R.drawable.planks,
//            DatasetRes = R.string.desc_1h,
//            HowTo = R.string.How_to,
//            DesRes = R.string.desc_1), modifier = Modifier)
        ActualApp()
    }
}