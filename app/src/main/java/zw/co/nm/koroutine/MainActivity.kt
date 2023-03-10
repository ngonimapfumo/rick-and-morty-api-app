package zw.co.nm.koroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import retrofit2.*
import zw.co.nm.koroutine.databinding.ActivityMainBinding
import zw.co.nm.koroutine.models.GetCharacterByIdResponse
import zw.co.nm.koroutine.networking.NetworkLayer
import zw.co.nm.koroutine.viewmodel.SharedViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val viewModel: SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        viewModel.refreshCharacter(89)
       viewModel.characterByIdLiveData.observe(this){ response->
           if(response==null){
               return@observe
           }
           Toast.makeText(this@MainActivity,response.species,Toast.LENGTH_LONG).show()
       }

    }
}