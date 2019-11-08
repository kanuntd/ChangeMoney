package buu.informatics.s59161081.changmoney

import androidx.lifecycle.ViewModel
import buu.informatics.s59161081.changmoney.database.ResultCurrency

class CompareViewModel : ViewModel(){
    var rs = 0.00
    var sym = "$"
    var name = "USD"
    fun getValue(paidEdit : String ,currency : String){
        var input = paidEdit
        var resultCurrency  = ResultCurrency()
        if(paidEdit == ""){
            input = "0"
        }
        if(currency == "USD"){
             rs =   String.format("%.4f",input.toInt()*resultCurrency.usd).toDouble()
        }else if(currency == "EUR"){
            rs =   String.format("%.4f",input.toInt()*resultCurrency.eur).toDouble()

        }else if(currency  == "CAD"){
            rs =   String.format("%.4f",input.toInt()*resultCurrency.cad).toDouble()
        }
    }
    fun setSymbolAndName(currency: String){
        if(currency == "USD"){
            sym = "$"
            name = currency
        }else if(currency == "EUR"){
            sym = "€"
            name = currency

        }else if(currency  == "CAD"){
            sym = "$"
            name = currency
        }
    }
}