package hu.nagyi.incomeexpensesecondweekwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.nagyi.incomeexpensesecondweekwork.databinding.FragmentExpenseBinding

class FragmentExpense : MyFragment() {

    //region VARIABLES

    private var _binding: FragmentExpenseBinding? = null
    private val binding get() = _binding!!

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentExpense()
    }

    //endregion

    //region METHODS

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this._binding = FragmentExpenseBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding.saveBtn.setOnClickListener(View.OnClickListener {
            if (this.binding.expenseValueET.text.isNotEmpty()) {
                val value = Integer.valueOf(this.binding.expenseValueET.text.toString())
                DataManager.expense = (DataManager.expense + value)
                this.showToast(this@FragmentExpense.activity, R.string.addedValue, value)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //endregion
}