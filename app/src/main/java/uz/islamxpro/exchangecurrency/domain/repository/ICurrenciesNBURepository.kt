package uz.islamxpro.exchangecurrency.domain.repository

import uz.islamxpro.exchangecurrency.domain.model.CurrencyNBU
import io.reactivex.Single

interface ICurrenciesNBURepository {
    fun currenciesNBU(date: String): Single<List<CurrencyNBU>>
}