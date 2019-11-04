package buu.informatics.s59161081.changmoney

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

class IndexViewModel : ViewModel() {
    private val timer: CountDownTimer
    companion object {

        private const val DONE = 0L
        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 3000L

    }
    init {
        Log.i("IndexViewModel", "IndexViewModel created!")
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished/ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinish()

            }
        }

        timer.start()
    }

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val _eventIndexFinish = MutableLiveData<Boolean>()
    val eventIndexFinish: LiveData<Boolean>
        get() = _eventIndexFinish

    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }


    fun onGameFinish() {
        _eventIndexFinish.value = true
    }




}