package com.example.photogallery

import androidx.lifecycle.*
import com.example.photogallery.model.GalleryItem

class PhotoGalleryViewModel() : ViewModel() {

    val galleryItemLiveData: LiveData<List<GalleryItem>>
    private val flickrFetchr = FlickrFetchr()
    private val mutableSearchTerm = MutableLiveData<String>()

    val searchTerm: String
        get() = mutableSearchTerm.value ?: ""

    init {
        mutableSearchTerm.value = ""
        galleryItemLiveData =
            Transformations.switchMap(mutableSearchTerm) { searchTerm ->
                if (searchTerm.isBlank()) {
                    flickrFetchr.fetchPhotos()
                } else {
                    flickrFetchr.searchPhotos(searchTerm)
                }
            }
        }

    fun fetchPhotos(query: String = "") {
        mutableSearchTerm.value = query
    }
}