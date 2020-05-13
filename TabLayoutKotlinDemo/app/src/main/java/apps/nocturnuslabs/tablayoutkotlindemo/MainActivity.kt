package apps.nocturnuslabs.tablayoutkotlindemo

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    //initializing the variables
    private lateinit var toolbar : Toolbar
    private lateinit var viewPager : ViewPager
    private lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.main_viewpager)
        tabLayout = findViewById(R.id.main_tablayout)

        //adding the fragments
        val exploreFragment = ExploreFragment()
        val flightFragment = FlightFragment()
        val travelFragment = TravelFragment()

        tabLayout.setupWithViewPager(viewPager)

        //we create a class ViewPagerAdapter that extends FragmentPagerAdapter
        val viewPagerAdapter : ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager,0)

        //we add the fragments to our adapter along with their titles
        viewPagerAdapter.addFragment(exploreFragment,"Explore")
        viewPagerAdapter.addFragment(flightFragment,"Flights")
        viewPagerAdapter.addFragment(travelFragment,"Travel")

        viewPager.adapter = viewPagerAdapter

        //this is to add icons to our tabs. it is optional
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_explore)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_airplane)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_beach_access)

        //if we want to add badges to our tabs
        val badgeDrawable : BadgeDrawable? = tabLayout.getTabAt(0)?.orCreateBadge
        if (badgeDrawable != null) {
            badgeDrawable.isVisible = true
            badgeDrawable.number = 12
        }

    }

    //custom class made for our tabs
    private class ViewPagerAdapter(fm: FragmentManager, behaviour: Int) :
        FragmentPagerAdapter(fm, behaviour) {

        //two mutable lists are defined to add fragments and their titles
        private var fragments :MutableList<Fragment> = ArrayList()
        private var fragmentTitles : MutableList<String> = ArrayList()

        //function to add the fragments and titles
        fun addFragment(fragment: Fragment, title:String) {
            fragments.add(fragment)
            fragmentTitles.add(title)
        }

        //function to set the title of the page
        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitles[position]
        }

        //overriding abstract methods of class FragmentPagerAdapter
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

    }
}
