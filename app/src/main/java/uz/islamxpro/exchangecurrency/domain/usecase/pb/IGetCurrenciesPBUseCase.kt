package uz.islamxpro.exchangecurrency.domain.usecase.pb

import uz.islamxpro.exchangecurrency.domain.model.ResponsePB
import io.reactivex.Single

interface IGetCurrenciesPBUseCase {
    operator fun invoke(date: String): Single<ResponsePB>
}