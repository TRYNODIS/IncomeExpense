package hu.nagyi.incomeexpensesecondweekwork

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentStatePagerAdapter(fragment: MyFragment, private val itemsCount: Int) :
    FragmentStateAdapter(fragment) {

    //region METHODS

    override fun getItemCount(): Int {
        return this.itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            FragmentIncome.newInstance()
        } else {
            FragmentExpense.newInstance()
        }
    }

    //endregion
}