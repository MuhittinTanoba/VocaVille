package com.example.vocaville

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
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
fun CategoryScreen(modifier: Modifier){
    CategoryList()
}

@Composable
@Preview
fun CategoryCardsCollection(){
    Surface (
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 10.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.error
            )
    ){
        Box{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.size(120.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.category),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(50.dp)
                )
                Text(
                    text = "Category Name",
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }

    }
}


@Composable
@Preview
fun CategoryList(){
    Box(
      modifier = Modifier.fillMaxWidth()
    ) {
        Column (
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
        ){
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