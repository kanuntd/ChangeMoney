package buu.informatics.s59161081.changmoney

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ItemAdapter (private val context: Context?,
                   private val array: ArrayList<Currency>) : BaseAdapter(){
    override fun getCount(): Int {
        return array.size
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
      //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(p0: Int): Any {
        return array[p0]
       //To change body of created functions use File | Settings | File Templates.
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val result : Currency = getItem(p0) as Currency
        val row = inflater.inflate(R.layout.currencylayout,p2,false)
        var text = row.findViewById(R.id.nameText) as TextView;
        text.text =  result.name
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    private val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

}