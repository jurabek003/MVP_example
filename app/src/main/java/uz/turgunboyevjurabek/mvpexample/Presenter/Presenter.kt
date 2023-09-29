package uz.turgunboyevjurabek.mvpexample.Presenter

import android.content.Context
import android.widget.Toast
import uz.turgunboyevjurabek.mvpexample.Contract.Contract

class Presenter(private var mainView:Contract.View?,private val model: Contract.Model,val context: Context)
    :Contract.Presenter,Contract.Model.OnFinishedListener {

    override fun onFinished(string: String?) {
        if (mainView!=null){
            mainView?.hideProgress()
            mainView?.setString(string)
        }
    }

    override fun onButtonClick() {
        if(mainView != null){
            mainView?.showProgress()
        }
        model.getNextCourse(this)
    }

    override fun onStarted() {
        Toast.makeText(context, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onCreated() {
        Toast.makeText(context, "onCreated", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        Toast.makeText(context, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        Toast.makeText(context, "onPousse", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        Toast.makeText(context, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        mainView=null
        Toast.makeText(context, "Destroyed", Toast.LENGTH_SHORT).show()
    }
}