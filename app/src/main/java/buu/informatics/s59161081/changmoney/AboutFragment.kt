package buu.informatics.s59161081.changmoney


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161081.changmoney.databinding.FragmentAboutBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater,
                R.layout.fragment_about,container,false)

            binding.aboutButton.setOnClickListener { view : View ->
                view.findNavController().navigate(R.id.action_aboutFragment_to_compareFragment)
            }

            return binding.root
        }

}
