package buu.informatics.s59161081.changmoney


import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import buu.informatics.s59161081.changmoney.databinding.FragmentIndexBinding

/**
 * A simple [Fragment] subclass.
 */
class IndexFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentIndexBinding>(inflater,
            R.layout.fragment_index,container,false)
        object : CountDownTimer(1000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                findNavController().navigate(R.id.action_indexFragment_to_compareFragment)
            }
        }.start()


        return binding.root
    }






}
