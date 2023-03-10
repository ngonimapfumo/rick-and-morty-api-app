package zw.co.nm.koroutine.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import zw.co.nm.koroutine.models.GetCharacterByIdResponse
import zw.co.nm.koroutine.repository.SharedRepository

class SharedViewModel : ViewModel() {

    private val repository = SharedRepository()

    private val _characterByIdLiveData = MutableLiveData<GetCharacterByIdResponse>()
    val characterByIdLiveData:LiveData<GetCharacterByIdResponse> = _characterByIdLiveData


    fun refreshCharacter(characterId:Int){
        viewModelScope.launch {
            val response = repository.getCharacterById(characterId)
            _characterByIdLiveData.postValue(response)
        }
    }
}