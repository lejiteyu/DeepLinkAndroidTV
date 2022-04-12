package lyon.deeplink.sample

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import lyon.deeplink.sample.databinding.FragmentFirstBinding
import org.json.JSONException
import org.json.JSONObject

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

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            //Ref:https://louis383.medium.com/android-app-links-%E8%A8%AD%E5%AE%9A%E5%BF%83%E5%BE%97%E7%AD%86%E8%A8%98-6bd8ab212297
            try {
                //使用 Url
                val netflix = Intent()
                netflix.action = Intent.ACTION_VIEW
                netflix.data =
                    Uri.parse("http://video.friday.tw/home/70202141?linkType=12&linkValue=3&src=mWeb")
               //netflix.putExtra("search", "30") // careful: String, not int
                netflix.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(netflix)


            }catch (e:Exception){
                openStore()
            }
        }
        binding.buttonFirst.requestFocus();

        //使用Intent 開啟第三方app
        binding.buttonSecond.setOnClickListener {
            try {
                val intent = Intent()
                intent.setAction("com.friday.tvapp")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.addFlags(0x01000000) //20210913 sdk > 8.0 要喚起背景app 需要使用
                intent.putExtra("linkType", "10")//詳細頁10
                intent.putExtra("linkValue", "2413_3")//contentId_contentType
                startActivity(intent)
            }catch (e:Exception){
                openStore()
            }
        }
    }

    fun openStore(){
        val appPackageName: String ="net.fetnet.fetvod.tv"
        // getPackageName() from Context or Activity object
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                )
            )
        } catch (anfe: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}