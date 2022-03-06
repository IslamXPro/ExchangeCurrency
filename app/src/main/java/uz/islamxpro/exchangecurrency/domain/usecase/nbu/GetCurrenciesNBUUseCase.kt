package uz.islamxpro.exchangecurrency.domain.usecase.nbu

import uz.islamxpro.exchangecurrency.domain.model.CurrencyNBU
import uz.islamxpro.exchangecurrency.domain.repository.ICurrenciesNBURepository
import io.reactivex.Single

class GetCurrenciesNBUUseCase constructor(
    private val currenciesNBURepository: ICurrenciesNBURepository
): IGetCurrenciesNBUUseCase {
    override operator fun invoke(date: String): Single<List<CurrencyNBU>> =
        currenciesNBURepository.currenciesNBU(date)
}