package com.universe.totalplaytest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universe.totalplaytest.domain.model.BankArrayReference
import com.universe.totalplaytest.domain.model.ClientResponse
import com.universe.totalplaytest.domain.use_cases.ClientDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientResponseViewModel @Inject constructor(
    private val getClientDetail: ClientDetail
): ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val clientResponse = MutableLiveData<List<BankArrayReference>>()

    fun onCreate(idSession: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getClientDetail(idSession)
            if(result.status==0){
                clientResponse.postValue(result.arrayReferences!!)
            }
            isLoading.postValue(false)
        }
    }
}