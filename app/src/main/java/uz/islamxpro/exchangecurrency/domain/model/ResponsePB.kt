package uz.islamxpro.exchangecurrency.domain.model

import uz.islamxpro.exchangecurrency.domain.model.CurrencyPB

data class ResponsePB(
    var date: String,
    var bank: String,
    var baseCurrency: Int,
    var baseCurrencyLis: String,
    var exchangeRate: List<CurrencyPB>
)