package buu.informatics.s59161081.changmoney


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ShareActionProvider
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        setHasOptionsMenu(true)
        Log.i("CompareFragment", "onCreateView called")
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return NavigationUI.onNavDestinationSelected(item!!,
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
