package com.example.semana4_1_retrofit.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semana4_1_retrofit.model.Sites
import com.example.semana4_1_retrofit.model.client.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.collections.arrayListOf

/**
* This file is important because it defines the SitesViewModel class,
* which is responsible for managing and preparing data for the UI in an Android application that uses Retrofit to fetch data from a web service. The ViewModel interacts with the Repository to retrieve a list of sites and exposes this data as LiveData, allowing the UI to observe changes and update accordingly.
* This separation of concerns helps maintain a clean architecture and improves the testability and maintainability of the code.
*
* Also is necessary to connect the View with the Model in other words the UI with the data source.
* Intermediary between the view and the model
 *
 * @param siteList
 * This is a mutable state property that holds a list of Sites objects.
 * It is initialized as an empty ArrayList and is used to store
 * the data fetched from the web service.
*/

class SitesViewModel: ViewModel() {

    var siteList: ArrayList<Sites> by mutableStateOf(arrayListOf())

    fun getSites(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getSitios()
            withContext(Dispatchers.Main){
                if (response.body() != null){
                    siteList = response.body() as ArrayList<Sites>
                } else {
                    siteList = arrayListOf()
                }
            }
        }
    }
}