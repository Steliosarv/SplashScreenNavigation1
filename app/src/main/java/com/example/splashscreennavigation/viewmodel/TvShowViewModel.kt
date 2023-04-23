package com.example.splashscreennavigation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreennavigation.Repository.ApiRepository
import com.example.tvshowapp.models.TvShowItem
import kotlinx.coroutines.launch

class TvShowViewModel constructor(private val repository: ApiRepository): ViewModel() {


        private val _response = MutableLiveData<List<TvShowItem>>()
        val responseTvShow: LiveData<List<TvShowItem>> get() = _response


    init{
        getTvShows()

    }

    private fun getTvShows()= viewModelScope.launch {
            repository.getAllTvShows().let {response ->
                if(response.isSuccessful){
                    _response.postValue(response.body())

                }
                else {
                    Log.d("tag", "getAllTvshows Error")
                }

            }
    }



}