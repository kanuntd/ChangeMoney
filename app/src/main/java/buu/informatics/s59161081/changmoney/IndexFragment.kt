package buu.informatics.s59161081.changmoney

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.informatics.s59161081.changmoney.databinding.FragmentIndexBinding



/**
 * A simple [Fragment] subclass.
 */
class IndexFragment : Fragment() {
    private lateinit var viewModel: IndexViewModel
    private lateinit var binding: FragmentIndexBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_index,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(IndexViewModel::class.java)
        binding.indexViewModel = viewModel
        viewModel.eventIndexFinish.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) gameFinished()
        })
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun gameFinished() {
        Toast.makeText(activity, "Chang Money Start!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_indexFragment_to_compareFragment)
    }




}
