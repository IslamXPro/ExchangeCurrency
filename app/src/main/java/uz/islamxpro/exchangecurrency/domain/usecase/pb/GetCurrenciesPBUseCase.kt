package uz.islamxpro.exchangecurrency.domain.usecase.pb

import uz.islamxpro.exchangecurrency.domain.model.ResponsePB
import uz.islamxpro.exchangecurrency.domain.repository.ICurrenciesPBRepository
import io.reactivex.Single

class GetCurrenciesPBUseCase constructor(
    private val currenciesPBRepository: ICurrenciesPBRepository
): IGetCurrenciesPBUseCase {
    override operator fun invoke(date: String): Single<ResponsePB> =
        currenciesPBRepository.currenciesPB(date)
}