package uz.islamxpro.exchangecurrency.data.api

import uz.islamxpro.exchangecurrency.domain.model.CurrencyNBU
import uz.islamxpro.exchangecurrency.domain.model.ResponsePB
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("exchange_rates?json")
    fun currenciesPB(@Query("date") date: String): Single<ResponsePB>

    @GET("exchange?")
    fun currenciesNBU(@Query("date") date: String,
                      @Query("json") json: String = ""): Single<List<CurrencyNBU>>
}