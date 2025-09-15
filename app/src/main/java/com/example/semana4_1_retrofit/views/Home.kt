package com.example.semana4_1_retrofit.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.semana4_1_retrofit.model.Sites

/**
 * This composable function displays a list of sites in a scrollable column.
 * It uses a LazyColumn to efficiently render the list items.
 *
 * @param sitesList
 * An ArrayList of Sites objects to be displayed.
 * Each site is represented as a card containing an image and text details.
 *
 * */

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Home(sitesList: ArrayList<Sites>){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        // LazyColumn to scroll through the list of sites
        LazyColumn(
            contentPadding = PaddingValues(
                horizontal = 15.dp,
                vertical = 5.dp
            )
        ) {
            items(sitesList){
                site -> (Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        Arrangement.Center
                    ) {
                        GlideImage(
                            model = site.imagen,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 200.dp)
                        )
                        Text(text = "SitioID: ${site.idSitio}")
                        Text(text = "SitioID: ${site.nombre}")
                    }
            })
            }
        }
    }

}