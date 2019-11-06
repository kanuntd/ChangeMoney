package buu.informatics.s59161081.changmoney.Compare

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59161081.changmoney.R
import buu.informatics.s59161081.changmoney.database.Currency

class SelectAdapter(f : Fragment) : RecyclerView.Adapter<SelectAdapter.ViewHolder>() {
    var fragment: Fragment = f
    var args:String = ""
    var usa: Currency = Currency("USD", "US Dollar", "1USD=30.3313")
    var eur: Currency = Currency("EUR", "Euro", "1EUR=33.3136")
    var cad: Currency = Currency("CAD", "Canadian Dollar", "1CAD=22.7928")
    var listData =  ArrayList<Currency>()


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.shortnessSelect)
        val itemShort: TextView = itemView.findViewById(R.id.nameSelect)
        val itemImage: ImageView = itemView.findViewById(R.id.imageSelect)
        val itemId : ConstraintLayout = itemView.findViewById(R.id.idSelect)


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.selectlayout, parent, false)
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
        holder.bind(item,fragment)
    }


    fun ViewHolder.bind(item: Currency,f : Fragment) {
        itemName.text = item.nameCu
        itemShort.text = item.shortness
        if (item.shortness == "USD") {
            itemImage.setImageResource(R.drawable.usa)

        } else if (item.shortness == "EUR") {
            itemImage.setImageResource(R.drawable.eur)
        } else {
            itemImage.setImageResource(R.drawable.canada)
        }
        itemId.setOnClickListener{view: View ->
            view.findNavController().navigate(SelectFragmentDirections.actionSelectFragmentToCompareFragment(itemShort.text.toString()))
        }
    }

    fun sendData(send: String) {
        args = send
        var list = listOf<Currency>(usa,eur,cad)
        for(item in list){
            if(item.shortness == args){

            }else{
                listData.add(item)
            }
        }
    }

    var data = listData
        set(value) {
            field = value
            notifyDataSetChanged()
        }


}



