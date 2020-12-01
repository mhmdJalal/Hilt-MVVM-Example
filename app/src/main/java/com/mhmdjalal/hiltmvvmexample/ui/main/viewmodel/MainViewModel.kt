package com.mhmdjalal.hiltmvvmexample.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mhmdjalal.hiltmvvmexample.utils.request
import com.mhmdjalal.hiltmvvmexample.data.model.response.CharacterResponse
import com.mhmdjalal.hiltmvvmexample.data.repository.MainRepository
import com.mhmdjalal.hiltmvvmexample.utils.NetworkHelper
import com.mhmdjalal.hiltmvvmexample.utils.Resource
import com.mhmdjalal.hiltmvvmexample.utils.Status
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _characters = MutableLiveData<Resource<CharacterResponse>>()
    val characters: LiveData<Resource<CharacterResponse>>
        get() = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                request(viewModelScope, { mainRepository.getCharacters() }, {
                    when(it.status) {
                        Status.ERROR -> {
                            _characters.postValue(Resource.error(it.message, null))
                        }
                        Status.LOADING -> {
                            _characters.postValue(Resource.loading(null))
                        }
                        Status.SUCCESS -> {
                            _characters.postValue(Resource.success(it.data))
                        }
                    }
                })
            } else {
                _characters.postValue(Resource.error("No internet connection", null))
            }
        }
    }
}