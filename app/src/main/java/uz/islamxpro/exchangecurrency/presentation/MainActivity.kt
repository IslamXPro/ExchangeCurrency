package uz.islamxpro.exchangecurrency.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangecurrency.presentation.RecyclerAdapter
import uz.islamxpro.exchangecurrency.R
import uz.islamxpro.exchangecurrency.databinding.ActivityMainBinding
import uz.islamxpro.exchangecurrency.domain.model.CurrencyNBU
//import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    private val currenciesViewModel: CurrenciesViewModel = CurrenciesViewModel()

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = currenciesViewModel
        binding.lifecycleOwner = this

        currenciesViewModel.loadCurrencies()
        currenciesViewModel.currencyNBUList.observe(this) {
            initRecyclerView(it)
        }

//        //pb item
//        binding.eurCurrencyLayout.setOnClickListener {
//            scrollToIndex("EUR")
//        }
//        binding.usdCurrencyLayout.setOnClickListener {
//            scrollToIndex("USD")
//        }
//        binding.rubCurrencyLayout.setOnClickListener {
//            scrollToIndex("RUB")
//        }
    }

    private fun initRecyclerView(list: List<CurrencyNBU>) {
        layoutManager = LinearLayoutManager(this)
        binding.nbuCurrenciesRecyclerView.layoutManager = layoutManager
        binding.nbuCurrenciesRecyclerView.setHasFixedSize(true)
        binding.nbuCurrenciesRecyclerView.isNestedScrollingEnabled = false
        binding.nbuCurrenciesRecyclerView.adapter = RecyclerAdapter(list)
    }

    fun scrollToIndex(currency: String) {
//        val item = currencyNBUList.find { it.cc == currency }
//        val index = currencyNBUList.indexOf(item)
//        layoutManager.scrollToPositionWithOffset(index, 0)
//
//        return index;
    }
}