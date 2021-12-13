package hu.nagyi.incomeexpensesecondweekwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import com.amirarcane.lockscreen.activity.EnterPinActivity
import hu.nagyi.incomeexpensesecondweekwork.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //region VARIABLES

    private lateinit var binding: ActivityMainBinding
    private val activityLauncher: MyActivityResult<Intent, ActivityResult> =
        MyActivityResult.registerActivityForResult(this)

    //endregion

    //region METHODS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        this.setContentView(this.binding.root)

        this.activityLauncher.launch(
            Intent(this, EnterPinActivity::class.java),
            object : MyActivityResult.OnActivityResult<ActivityResult> {
                override fun onActivityResult(result: ActivityResult) {
                    if (result.resultCode == EnterPinActivity.RESULT_BACK_PRESSED) {
                        this@MainActivity.finishAffinity()
                    }
                }
            })
    }

    //endregion
}