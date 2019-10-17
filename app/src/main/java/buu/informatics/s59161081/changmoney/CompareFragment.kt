package buu.informatics.s59161081.changmoney


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161081.changmoney.databinding.FragmentCompareBinding

/**
 * A simple [Fragment] subclass.
 */
class CompareFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCompareBinding>(inflater,
            R.layout.fragment_compare,container,false)
        binding.converterButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_compareFragment_to_converterFragment)
        }
        binding.favoriteButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_compareFragment_to_favoriteFragment)
        }
        return binding.root
    }


}
