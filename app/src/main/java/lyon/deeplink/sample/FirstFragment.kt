package lyon.deeplink.sample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import lyon.deeplink.sample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {

            //Ref:https://louis383.medium.com/android-app-links-%E8%A8%AD%E5%AE%9A%E5%BF%83%E5%BE%97%E7%AD%86%E8%A8%98-6bd8ab212297
            val netflix = Intent()
            netflix.action = Intent.ACTION_VIEW
            netflix.data = Uri.parse("http://video.friday.tw/home/70202141?linkType=12&linkValue=3&src=mWeb")
            netflix.putExtra("search", "30") // careful: String, not int

            netflix.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(netflix)
        }
        binding.buttonFirst.requestFocus();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}