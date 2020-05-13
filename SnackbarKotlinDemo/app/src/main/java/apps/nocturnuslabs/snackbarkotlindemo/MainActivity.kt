package apps.nocturnuslabs.snackbarkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var mSnackbarbtn : MaterialButton
    lateinit var mFloatingActionButton: FloatingActionButton
    lateinit var mCoordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFloatingActionButton = findViewById(R.id.main_fab)

        //coordinatorLayout is used to make snackbar appear below the fab and not overlap it.
        mCoordinatorLayout = findViewById(R.id.main_coordinatorLayout)

        mSnackbarbtn = findViewById(R.id.main_snackbarbtn)
        mSnackbarbtn.setOnClickListener {


            //Show the snackbar indefinitely until user dismisses it using action.
            val snackbar:Snackbar = Snackbar.make(mCoordinatorLayout,"Snackbar button clicked",Snackbar.LENGTH_INDEFINITE)

            //You can also set snackbar duration in milliseconds
            //snackbar.duration = 1000

            //we can also define animation the snackbar uses to appear
            snackbar.animationMode = Snackbar.ANIMATION_MODE_SLIDE

            //implementing action present in snackbar (dismissing the snackbar in this case)
            snackbar.setAction("Okay") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
    }
}
