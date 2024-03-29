package buu.informatics.s59161081.changmoney.Favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161081.changmoney.Converter.CurrencyAdapter
import buu.informatics.s59161081.changmoney.R
import buu.informatics.s59161081.changmoney.databinding.FragmentFavoriteBinding
import kotlinx.android.synthetic.main.fragment_favorite.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentFavoriteBinding>(inflater,
            R.layout.fragment_favorite,container,false)
        binding.compareButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_favoriteFragment_to_compareFragment)
        }
        binding.converterButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_favoriteFragment_to_converterFragment)
        }

        val myWebView: WebView = binding.chartWeb
        myWebView.loadUrl("https://couponbangsean.netlify.com/")


        return binding.root
    }



}
