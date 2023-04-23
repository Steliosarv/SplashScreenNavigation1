package com.example.splashscreennavigation.Repository

import com.example.splashscreennavigation.api.ServiceApi

class ApiRepository constructor(private val api: ServiceApi) {

        suspend fun getAllTvShows() = api.getTvShows()

}