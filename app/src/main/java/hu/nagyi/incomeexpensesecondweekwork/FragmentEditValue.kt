package hu.nagyi.incomeexpensesecondweekwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import hu.nagyi.incomeexpensesecondweekwork.databinding.FragmentEditValueBinding

class FragmentEditValue : MyFragment() {

    //region VARIABLES

    private var _binding: FragmentEditValueBinding? = null
    private val binding get() = _binding!!
    private lateinit var pageNames: Array<String>
/*    private var pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            this@FragmentEditValue.showToast(this@FragmentEditValue.activity, R.string.selectedPosition, position)
        }
    }*/

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentEditValue()
    }

    //endregion

    //region METHODS

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this._binding = FragmentEditValueBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.pageNames = resources.getStringArray(R.array.tab_names)

        this.binding.mainViewPager.adapter = MyFragmentStatePagerAdapter(this@FragmentEditValue, 2)

        this.binding.mainViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        this.binding.mainViewPager.setPageTransformer(HorizontalFlipTransformation())

        //this.binding.mainViewPager.registerOnPageChangeCallback(this.pageChangeCallback)

        TabLayoutMediator(this.binding.tabLayout, this.binding.mainViewPager) { tab, position ->
            tab.text = this.pageNames[position]
        }.attach()
    }


    override fun onDestroyView() {
        //this.binding.mainViewPager.unregisterOnPageChangeCallback(this.pageChangeCallback)
        super.onDestroyView()
        _binding = null
    }

    //endregion
}