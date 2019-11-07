package buu.informatics.s59161081.changmoney.Compare


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59161081.changmoney.R
import buu.informatics.s59161081.changmoney.database.ResultCurrency
import buu.informatics.s59161081.changmoney.databinding.FragmentCompareBinding
import buu.informatics.s59161081.changmoney.databinding.FragmentIndexBinding
import kotlinx.android.synthetic.main.fragment_compare.*
import kotlinx.android.synthetic.main.fragment_converter.*
import kotlinx.android.synthetic.main.fragment_favorite.*

/**
 * A simple [Fragment] subclass.
 */
class CompareFragment : Fragment() {

    lateinit var args :CompareFragmentArgs
    private lateinit var binding: FragmentCompareBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentCompareBinding>(inflater,
            R.layout.fragment_compare,container,false)
        binding.converterButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_compareFragment_to_converterFragment)
        }
        binding.favoriteButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_compareFragment_to_favoriteFragment)
        }

        binding.imageChang2.setOnClickListener {view: View ->
            view.findNavController().navigate(CompareFragmentDirections.actionCompareFragmentToSelectFragment(binding.shrotnessCom.text.toString()))
        }

        binding.paidEditText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                getValue(paidEditText.text.toString())
            }
        })
        args = CompareFragmentArgs.fromBundle(arguments!!)
        if(args.selectCurrency == "EUR"){
            binding.apply {
                imageChang2.setImageResource(R.drawable.eur)
                shrotnessCom.setText(R.string.eur)
                symRe.setText(R.string.symE)
            }
        }else if(args.selectCurrency == "CAD"){
            binding.apply {
                imageChang2.setImageResource(R.drawable.canada)
                shrotnessCom.setText(R.string.cad)
                symRe.setText(R.string.symU)

            }
        }else if(args.selectCurrency == "USD") {
            binding.apply {
                imageChang2.setImageResource(R.drawable.usa)
                shrotnessCom.setText(R.string.usd)
                symRe.setText(R.string.symU)
            }
        }

        setHasOptionsMenu(true)
        Log.i("CompareFragment", "onCreateView called")

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.setVisible(false)
        }

    }
    fun getValue(paid : String){
        var resultCurrency  = ResultCurrency()
        var input = paidEditText.text.toString()
        if(paid == ""){
            input = "0"

        }

        binding.apply {
            if(shrotnessCom.text.toString() == "USD"){
                val rs =   String.format("%.4f",input.toInt()*resultCurrency.usd).toDouble()
                receivedText.text = rs.toString()
                symRe.setText(R.string.symU)
            }else if(shrotnessCom.text.toString() == "EUR"){
                val rs =   String.format("%.4f",input.toInt()*resultCurrency.eur).toDouble()
                receivedText.text = rs.toString()
                symRe.setText(R.string.symE)
            }else if(shrotnessCom.text.toString() == "CAD"){
                val rs =   String.format("%.4f",input.toInt()*resultCurrency.cad).toDouble()
                receivedText.text = rs.toString()
                symRe.setText(R.string.symU)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text))
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("CompareFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("CompareFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("CompareFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("CompareFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("CompareFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("CompareFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("CompareFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("CompareFragment", "onDetach called")
    }

}
