package uz.turgunboyevjurabek.mvpexample.Model

import android.os.Looper
import uz.turgunboyevjurabek.mvpexample.Contract.Contract
import java.util.Random
import java.util.logging.Handler

class Madel:Contract.Model {

    private val arrayList =
        listOf(
            "Android – shu yaqin yillarda IT sohasiga kirib kelgan va ko’p dasturchilarni, shu operatsion tizim bilan pul topishga undagan “yashil o’zga sayyoralik” dir.",
            "Flutter - Google tomonidan ishlab chiqilgan framework hisoblanadi. Bu kurs orqali siz bir vaqtning o'zida yangi til Dart ni o`rganib Android va iOS mobil ilovalarni yarata olasiz.",
            "iOS - Apple Inc. tomonidan yaratilgan va ishlab chiqarilgan mobil operatsion tizimdir. Hozirda kompaniyaning ko'plab mobil qurilmalarini, jumladan, iPhone, iPad va iPod Touchni quvvatlovchi operatsion tizim.",
            "Frontend dasturlash kursi orqali siz ko’plab dasturlash texnologiyalari ya’ni HTML, CSS, JavaScript, Bootstrap, Sass, jQuery singari texnologiyalarni mukammal o’rganishingiz mumkin."
        )

    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener?) {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            onFinishedListener?.onFinished(
                getRandomString
            )
        }, 1000)
    }
    private val getRandomString: String
        get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }

}