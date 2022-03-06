package uz.islamxpro.exchangecurrency.data.repository

import uz.islamxpro.exchangecurrency.data.api.CurrencyApi
import uz.islamxpro.exchangecurrency.domain.model.CurrencyNBU
import uz.islamxpro.exchangecurrency.domain.repository.ICurrenciesNBURepository
import io.reactivex.Single

class CurrenciesNBURepository constructor(
    private val currencyApi: CurrencyApi
) : ICurrenciesNBURepository {
    override fun currenciesNBU(date: String): Single<List<CurrencyNBU>> {
        return currencyApi.currenciesNBU(date)
    }
}