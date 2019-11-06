package buu.informatics.s59161081.changmoney.Converter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59161081.changmoney.R
import buu.informatics.s59161081.changmoney.database.Currency
import buu.informatics.s59161081.changmoney.database.ResultCurrency

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    var input : Int = 0
    var usa: Currency = Currency("USD", "US Dollar", "1USD=30.3313")
    var eur: Currency = Currency("EUR", "Euro", "1EUR=33.3136")
    var cad: Currency = Currency("CAD", "Canadian Dollar", "1CAD=22.7928")
    var resultCurrency : ResultCurrency = ResultCurrency()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemName: TextView = itemView.findViewById(R.id.shortnessText)
        val itemShort: TextView = itemView.findViewById(R.id.nameText)
        val itemImage: ImageView = itemView.findViewById(R.id.imageView)
        val itemSym: TextView = itemView.findViewById((R.id.symbolText))
        val itemResult: TextView = itemView.findViewById((R.id.resultText))
        val itemChange: TextView = itemView.findViewById((R.id.changText))

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.currencylayout, parent, false)
                return ViewHolder(view)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

    }

    fun ViewHolder.bind(item: Currency) {
        itemName.text = item.nameCu
        itemShort.text = item.shortness
        itemChange.text = item.chang
        if(item.shortness == "USD"){
            val rs = String.format("%.4f",input/resultCurrency.usd).toDouble()
            itemImage.setImageResource(R.drawable.usa)
            itemSym.setText(R.string.symU)
            itemResult.setText("$rs")
        }else if(item.shortness == "EUR"){
            val rs = String.format("%.4f",input/resultCurrency.eur).toDouble()
            itemImage.setImageResource(R.drawable.eur)
            itemSym.setText(R.string.symE)
            itemResult.setText("$rs")
        }else{
            val rs = String.format("%.4f",input/resultCurrency.cad).toDouble()
            itemImage.setImageResource(R.drawable.canada)
            itemSym.setText(R.string.symU)
            itemResult.setText("$rs")
        }

    }
    fun sendValue(send : Int){
        input = send
    }

    var data =  listOf(usa,eur,cad)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

}
