package apps.nocturnuslabs.bottomappbarkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.view.get
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var mBottomAppBar: BottomAppBar
    private lateinit var mFloatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomAppBar = findViewById(R.id.main_bottom_appbar)
        setSupportActionBar(mBottomAppBar)

        mFloatingActionButton = findViewById(R.id.main_fab)
        mFloatingActionButton.setOnClickListener {
            mBottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.bottom_app_bar_menu, menu)

        return true
    }

}
