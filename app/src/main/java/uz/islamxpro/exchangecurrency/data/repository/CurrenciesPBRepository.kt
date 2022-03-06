package uz.islamxpro.exchangecurrency.data.repository

import uz.islamxpro.exchangecurrency.data.api.CurrencyApi
import uz.islamxpro.exchangecurrency.domain.model.ResponsePB
import uz.islamxpro.exchangecurrency.domain.repository.ICurrenciesPBRepository
import io.reactivex.Single
import org.jetbrains.annotations.NotNull

class CurrenciesPBRepository constructor(
    private val currencyApi: CurrencyApi
) : ICurrenciesPBRepository {
    override fun currenciesPB(@NotNull date: String): Single<ResponsePB> {
        return currencyApi.currenciesPB(date)
    }
}