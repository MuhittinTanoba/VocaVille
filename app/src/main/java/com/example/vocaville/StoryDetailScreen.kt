package com.example.vocaville

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryDetailScreen(
    modifier: Modifier,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = "Story Name")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = {
            PaddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                ImageOfStory()
                TextOfStory()
            }
        },
    )
}

@Composable
fun ImageOfStory(){
    Image(
        painter = painterResource(id = R.drawable.kirmizibaslik),
        contentDescription = "Deneme",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextOfStory(){
    Text(
        text = "Bir varmış, bir yokmuş. Zamanın birinde tatlı mı tatlı, " +
                "küçük bir kız yaşarmış. Bu kızı kim görse hemen severmiş." +
                " Ama en çok da anneannesi severmiş. " +
                "Anneannesi bu çocuğa artık ne vereceğini bilemiyormuş. " +
                "Bir keresinde ona kırmızı renkte, kadife, küçük bir başlık vermiş. " +
                "Kendisine çok yakıştığından üzerinden hiç çıkarmadığı için kıza Kırmızı Başlıklı Kız demeye başlamışlar.\n" +
                "\n" +
                "Günlerden bir gün annesi ona demiş ki: “Gel Kırmızı Başlıklı Kız. Burada bir parça kekle bir şişe şarap var. Bunları anneannene götür. Anneannen hasta ve halsiz. Bunlar onu iyileştirecektir. Hareketlerine dikkat et ve ona selamımı ilet. Yolda giderken uslu ol ve yolu terk etme. Yoksa düşüp camı kırarsın. Sonra da hasta anneannene götürecek bir şeyin kalmaz.”\n" +
                "\n" +
                "Kırmızı Başlıklı Kız annesinin sözünü dinleyeceğine söz vermiş. Anneannesi, köyden yarım saat uzakta, ormanın içinde yaşıyormuş. Kırmızı Başlıklı Kız ormana girdiğinde yanına bir kurt gelmiş. Onun ne kadar şeytani bir hayvan olduğunu bilmediği için ondan korkmamış." +
                "",
    )
}