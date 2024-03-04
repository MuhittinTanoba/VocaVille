package com.example.vocaville

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryScreen(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        StoryHeader()
        StoryCardList()
        CategoryHeader()
        CategoryList()
    }
}

@Composable
fun StoryHeader() {
    Text(text = "Stories")
}

@Composable
fun CategoryHeader(){
    Text(text = "Category")
}
@Composable
@Preview
fun CategoryCardsCollection() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
    ) {
        Box {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.size(155.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.category),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(30.dp)
                )
                Text(
                    text = "Category Name",
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Composable
fun CategoryList() {
    var deneme = listOf(
        "1",
        "2",
        "3",
        "4",
        "5"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(deneme) { item ->
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                CategoryCardsCollection()
                CategoryCardsCollection()
            }
        }
    }
}

@Preview
@Composable
fun CategoryListPreview() {
    CategoryList()
}


@Composable
fun StoryCard() {
    Surface(
        color = MaterialTheme.colorScheme.primary,

    ) {
        Box(
            modifier = Modifier
                .size(width = 285.dp, height = 140.dp)
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.error
                ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.category),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 285.dp, height = 140.dp)
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart),
                ) {
                Text(
                    text = "Date",
                    fontSize = 10.sp
                )
                Text(
                    text = "Category Name",
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Composable
fun StoryCardList(
    modifier: Modifier = Modifier,
){
    var StoryList = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
    )

    LazyRow (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
        items(StoryList) {item ->
            StoryCard()
        }
    }
}
