package buu.informatics.s59161081.changmoney.Converter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59161081.changmoney.R
import buu.informatics.s59161081.changmoney.database.Currency

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    var thai : Currency = Currency("THB","Thai Bath")
    var usa : Currency = Currency("USD","US Dollar")


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemName: TextView = itemView.findViewById(R.id.shortnessText)
        val itemShort: TextView = itemView.findViewById(R.id.nameText)
        val itemImage: ImageView = itemView.findViewById(R.id.imageView)

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
        if(item.shortness == "THB" ){
            itemImage.setImageResource(R.drawable.thai)
        }else if(item.shortness == "USD"){
            itemImage.setImageResource(R.drawable.usa)
        }else if(item.shortness == "EUR"){
            itemImage.setImageResource(R.drawable.eur)
        }else{
            itemImage.setImageResource(R.drawable.canada)
        }

    }

    var data =  listOf(thai,usa)
        set(value) {
            field = value
            notifyDataSetChanged()
        }



}
