package uz.islamxpro.exchangecurrency.presentation

import android.app.usage.UsageEvents
import android.media.metrics.Event
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uz.islamxpro.exchangecurrency.data.api.CurrencyApi
import uz.islamxpro.exchangecurrency.data.api.RetrofitClient
import uz.islamxpro.exchangecurrency.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    var api: CurrencyApi = RetrofitClient.retrofitService(Constants.BASE_URL_PB)

    fun <T> requestWithLiveData(
        liveData: MutableLiveData<UsageEvents.Event<T>>,
        request: suspend () -> ResponseWrapper<T>
    ) {
        liveData.postValue(Event.loading())

        this.viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = request.invoke()
                if (response.data != null) {
                    liveData.postValue(Event.success(response.data))
                } else if (response.error != null) {
                    liveData.postValue(Event.error(response.error))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                liveData.postValue(Event.error(null))
            }
        }
    }

    fun <T> requestWithCallback(
        request: suspend () -> ResponseWrapper<T>,
        response: (Event<T>) -> Unit
    ) {

        response(Event.loading())

        this.viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = request.invoke()

                launch(Dispatchers.Main) {
                    if (res.data != null) {
                        response(Event.success(res.data))
                    } else if (res.error != null) {
                        response(Event.error(res.error))
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                launch(Dispatchers.Main) {
                    response(Event.error(null))
                }
            }
        }
    }
}