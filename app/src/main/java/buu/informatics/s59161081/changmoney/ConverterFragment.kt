package buu.informatics.s59161081.changmoney


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161081.changmoney.databinding.FragmentConverterBinding

/**
 * A simple [Fragment] subclass.
 */
class ConverterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentConverterBinding>(inflater,
            R.layout.fragment_converter,container,false)
        binding.compareButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_converterFragment_to_compareFragment)
        }
        binding.favoriteButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_converterFragment_to_favoriteFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }



}