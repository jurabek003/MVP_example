package uz.turgunboyevjurabek.mvpexample.Presenter

import uz.turgunboyevjurabek.mvpexample.Contract.Contract

class Presenter(private var mainView:Contract.View?,private val model: Contract.Model):Contract.Presenter,Contract.Model.OnFinishedListener {

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

    override fun onDestroy() {
        mainView=null
    }
}