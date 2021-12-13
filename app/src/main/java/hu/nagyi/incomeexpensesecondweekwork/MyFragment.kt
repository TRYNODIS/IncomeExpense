package hu.nagyi.incomeexpensesecondweekwork

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

open class MyFragment : Fragment() {

    //region VARIABLES



    //endregion

    //region METHODS

    fun showToast(context: Context?, textId: Int, value: Int) {
        Toast.makeText(
            context,
            String.format(this.resources.getString(textId), value),
            Toast.LENGTH_SHORT
        ).show()
    }

    //endregion
}