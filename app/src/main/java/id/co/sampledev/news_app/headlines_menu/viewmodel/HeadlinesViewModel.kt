package id.co.sampledev.news_app.headlines_menu.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.co.sampledev.news_app.network.model.Headlines
import id.co.sampledev.news_app.network.services.ApiServices
import id.co.sampledev.news_app.network.services.Config
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeadlinesViewModel : ViewModel() {
    private val api = Config.buildApi(ApiServices::class.java)

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _headlines = MutableLiveData<Headlines?>()
    val headlines: MutableLiveData<Headlines?> = _headlines

    fun getHeadlines() {
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = api.getHeadlines()
                if (response.isSuccessful) {
                    val data = response.body()
                    _headlines.postValue(data)
                }
            } catch (e: Exception) {
                Log.d("Exception", e.message.toString())
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

}