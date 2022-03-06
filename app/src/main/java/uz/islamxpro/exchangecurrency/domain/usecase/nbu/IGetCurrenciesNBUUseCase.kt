package uz.islamxpro.exchangecurrency.domain.usecase.nbu

import uz.islamxpro.exchangecurrency.domain.model.CurrencyNBU
import io.reactivex.Single

interface IGetCurrenciesNBUUseCase {
    operator fun invoke(date: String): Single<List<CurrencyNBU>>
}