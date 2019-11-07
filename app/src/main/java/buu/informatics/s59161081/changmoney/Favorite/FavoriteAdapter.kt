package buu.informatics.s59161081.changmoney.Favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59161081.changmoney.R
import buu.informatics.s59161081.changmoney.database.Currency

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    var usa: Currency = Currency("USD", "US Dollar", "1USD=30.3313")
    var eur: Currency = Currency("EUR", "Euro", "1EUR=33.3136")
    var cad: Currency = Currency("CAD", "Canadian Dollar", "1CAD=22.7928")
    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemName: TextView = itemView.findViewById(R.id.nameFav)
        val itemShort: TextView = itemView.findViewById(R.id.shortnessFav)
        val itemImage: ImageView = itemView.findViewById(R.id.imageFav)

        companion object {
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.favoritelayout, parent, false)
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
       if(item.shortness == "USD"){
           itemImage.setImageResource(R.drawable.usa)

       }else if(item.shortness == "EUR"){

           itemImage.setImageResource(R.drawable.eur)

       }else{
           itemImage.setImageResource(R.drawable.canada)

       }
   }

    var data =  listOf(usa,eur,cad)
        set(value) {
            field = value
            notifyDataSetChanged()
        }


}

