package buu.informatics.s59161081.changmoney.Compare


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59161081.changmoney.R
import buu.informatics.s59161081.changmoney.databinding.FragmentSelectBinding

/**
 * A simple [Fragment] subclass.
 */
class SelectFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSelectBinding>(inflater,
            R.layout.fragment_select,container,false)
        setHasOptionsMenu(true)
        val args = SelectFragmentArgs.fromBundle(arguments!!)
        val adapter = SelectAdapter(this)
        binding.selectList.adapter = adapter
        adapter.sendData(args.clickCurrency)


        return binding.root
    }


}
