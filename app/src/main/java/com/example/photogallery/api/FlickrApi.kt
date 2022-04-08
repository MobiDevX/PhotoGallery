package com.example.photogallery.api

import com.example.photogallery.model.FlickrResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList" +
            "&api_key=4f721bbafa75bf6d2cb5af54f937bb70" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponse>

/* https://api.flickr.com/services/rest/?method=flickr.photos.search
&api_key=4f721bbafa75bf6d2cb5af54f937bb70&format=json&nojsoncallback=1&extras=url_s&safe_search=1&text=flowers */

    @GET("services/rest/?method=flickr.photos.search" +
            "&api_key=4f721bbafa75bf6d2cb5af54f937bb70" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s")
    fun searchPhotos(@Query("text") query: String): Call<FlickrResponse>
}