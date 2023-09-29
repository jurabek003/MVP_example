package uz.turgunboyevjurabek.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.turgunboyevjurabek.mvpexample.Contract.Contract
import uz.turgunboyevjurabek.mvpexample.Contract.Contract.Model
import uz.turgunboyevjurabek.mvpexample.Model.Madel
import uz.turgunboyevjurabek.mvpexample.Presenter.Presenter
import uz.turgunboyevjurabek.mvpexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),Contract.View {
    var presenter: Presenter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this, Madel())
        binding.button.setOnClickListener { presenter?.onButtonClick() }
    }

    override fun showProgress() {
        binding.progressBar.visibility=View.VISIBLE
        binding.textView.visibility=View.GONE
    }

    override fun hideProgress() {
        binding.progressBar.visibility=View.GONE
        binding.textView.visibility=View.VISIBLE
    }

    override fun setString(string: String?) {
        binding.textView.text=string
    }
}