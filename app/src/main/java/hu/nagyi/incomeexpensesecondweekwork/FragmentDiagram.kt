package hu.nagyi.incomeexpensesecondweekwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import hu.nagyi.incomeexpensesecondweekwork.databinding.FragmentDiagramBinding
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel

class FragmentDiagram : MyFragment() {

    //region VARIABLES

    private var _binding: FragmentDiagramBinding? = null
    private val binding get() = _binding!!

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentDiagram()
    }

    //endregion

    //region METHODS

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this._binding = FragmentDiagramBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.setUpAndStartPieChart(this.binding.piechart)

        this.binding.editBtn.setOnClickListener {

            this.binding.root.findNavController()
                .navigate(R.id.action_fragmentDiagram_to_fragmentEditValue)

        }
    }

    private fun setUpAndStartPieChart(pieChart: PieChart) {
        if (DataManager.income == 0 && DataManager.expense == 0) {

        }
        else {
            pieChart.addPieSlice(
                PieModel(
                    this.resources.getString(R.string.income),
                    DataManager.income.toFloat(),
                    ContextCompat.getColor(requireContext(), R.color.chartOneColor)
                )
            )
            pieChart.addPieSlice(
                PieModel(
                    this.resources.getString(R.string.expense),
                    DataManager.expense.toFloat(),
                    ContextCompat.getColor(requireContext(), R.color.chartTwoColor)
                )
            )

            pieChart.startAnimation()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //endregion
}