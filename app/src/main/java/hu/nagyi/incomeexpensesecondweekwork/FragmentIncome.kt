package hu.nagyi.incomeexpensesecondweekwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.nagyi.incomeexpensesecondweekwork.databinding.FragmentIncomeBinding

class FragmentIncome : MyFragment() {

    //region VARIABLES

    private var _binding: FragmentIncomeBinding? = null
    private val binding get() = _binding!!

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentIncome()
    }

    //endregion

    //region METHODS

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this._binding = FragmentIncomeBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding.saveBtn.setOnClickListener(View.OnClickListener {
            if (this.binding.incomeValueET.text.isNotEmpty()) {
                val value = Integer.valueOf(this.binding.incomeValueET.text.toString())
                DataManager.income = (DataManager.income + value)
                this.showToast(this@FragmentIncome.activity, R.string.addedValue, value)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //endregion
}