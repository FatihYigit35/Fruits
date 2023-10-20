package app.web.valiantsoftware.fruitsvegetablesnutsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.web.valiantsoftware.fruitsvegetablesnutsapp.databinding.FragmentFruitDetailBinding
import app.web.valiantsoftware.fruitsvegetablesnutsapp.util.createPlaceholder
import app.web.valiantsoftware.fruitsvegetablesnutsapp.util.imageDownload
import app.web.valiantsoftware.fruitsvegetablesnutsapp.viewmodel.FruitDetailViewModel

class FruitDetailFragment : Fragment() {
    private lateinit var binding: FragmentFruitDetailBinding
    private lateinit var viewModel: FruitDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FruitDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFruitDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            val uuid = FruitDetailFragmentArgs.fromBundle(it).fruitId
            viewModel.getFruit(uuid)
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        with(viewModel) {
            with(binding) {
                fruitLiveData.observe(viewLifecycleOwner) {
                    it?.let {
                        fruit = it
                    }
                }
            }
        }
    }
}