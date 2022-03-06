package uz.islamxpro.exchangecurrency.domain.repository

import uz.islamxpro.exchangecurrency.domain.model.ResponsePB
import io.reactivex.Single
import org.jetbrains.annotations.NotNull

interface ICurrenciesPBRepository {
    fun currenciesPB(@NotNull date: String): Single<ResponsePB>
}