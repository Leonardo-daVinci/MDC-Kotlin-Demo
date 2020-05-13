package apps.nocturnuslabs.fabkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    //initializing FloatingActionButtons
    private lateinit var mFloatingActionButton: FloatingActionButton
    private lateinit var mFABpeople : FloatingActionButton
    private lateinit var mFABevent : FloatingActionButton

    //initializing TextViews
    private lateinit var mPeopleTextView : TextView
    private lateinit var mEventTextView: TextView

    //boolean to check if FAB is open or not
    private var isOpen : Boolean = false

    //initializing animations
    private lateinit var mFABOpenAnim : Animation
    private lateinit var mFABCloseAnim : Animation
    //private lateinit var mFABRotateAnim : RotateAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFloatingActionButton = findViewById(R.id.main_fab)
        mFABevent = findViewById(R.id.main_event_fab)
        mFABpeople = findViewById(R.id.main_people_fab)
        mPeopleTextView = findViewById(R.id.main_peopletxt)
        mEventTextView = findViewById(R.id.main_eventtxt)

        //loading animations
        mFABOpenAnim = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        mFABCloseAnim = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        //change visibility of views on pressing FAB
        mFloatingActionButton.setOnClickListener {
            mFloatingActionButton.animation = RotateAnimation(0.0F, 45.0F, 0.5F, 0.5F)
            if(isOpen){
                mFABpeople.animation = mFABCloseAnim
                mFABevent.animation = mFABCloseAnim
                mPeopleTextView.visibility = View.INVISIBLE
                mEventTextView.visibility = View.INVISIBLE
                isOpen = false
            }else{
                mFABpeople.animation = mFABOpenAnim
                mFABevent.animation = mFABOpenAnim
                mPeopleTextView.visibility = View.VISIBLE
                mEventTextView.visibility = View.VISIBLE
                isOpen = true
            }
        }
    }
}
