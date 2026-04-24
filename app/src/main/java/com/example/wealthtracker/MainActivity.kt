package com.example.wealthtracker
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.nn_ze_view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.nn_ze_tab_layout)

        // VERTICAL orientation — because "Nozadze" starts with a consonant
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        // Adapter tells ViewPager2 which fragments to show on each page
        viewPager.adapter = WealthPagerAdapter(this)

        // Connect tabs to the ViewPager2 and set tab labels
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Input"
                1 -> "Analytics"
                2 -> "Profile"
                else -> ""
            }
        }.attach()
    }
}

// Adapter: the bridge between ViewPager2 and your 3 fragments
class WealthPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Tell the adapter there are 3 pages
    override fun getItemCount(): Int = 3

    // Return the correct fragment for each page number
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> InputFragment()
            1 -> AnalyticsFragment()
            2 -> ProfileFragment()
            else -> InputFragment()
        }
    }
}