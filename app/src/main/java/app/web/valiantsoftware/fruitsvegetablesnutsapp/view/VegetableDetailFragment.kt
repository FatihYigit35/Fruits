package app.web.valiantsoftware.fruitsvegetablesnutsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.web.valiantsoftware.fruitsvegetablesnutsapp.R

class VegetableDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vegetable_detail, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}