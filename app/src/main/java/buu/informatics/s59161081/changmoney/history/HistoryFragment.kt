package buu.informatics.s59161081.changmoney.history


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160141.calculateelectricitybill.R
import buu.informatics.s59160141.calculateelectricitybill.databinding.FragmentHistoryBinding
import buu.informatics.s59161081.changmoney.R

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<Frag>(inflater,
            R.layout.fragment_favorite,container,false)
        binding.compareButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_favoriteFragment_to_compareFragment)
        }
        binding.converterButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_favoriteFragment_to_converterFragment)
        }



        return binding.root
    }



}
