package app.web.valiantsoftware.fruits.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.web.valiantsoftware.fruits.databinding.FragmentFruitDetailBinding
import app.web.valiantsoftware.fruits.viewmodel.FruitDetailViewModel

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
        binding = FragmentFruitDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFruit()

        arguments?.let {
            binding.fruitId = FruitDetailFragmentArgs.fromBundle(it).fruitId
        }

        observeLiveData()
    }

    private fun observeLiveData(){
        with(viewModel){
            with(binding){
                fruitLiveData.observe(viewLifecycleOwner) {
                    it?.let {
                        tvDetailFruitName.text = it.name
                        tvDetaiFruitDescription.text = it.description
                        tvDetaiFruitCalories.text = it.calories
                        tvDetaiFruitCarbohydrate.text = it.carbohydrate
                        tvDetaiFruitProtein.text = it.protein
                        tvDetaiFruitFat.text = it.fat

                        //TODO: resim işlemleri
                    }
                }
            }
        }

    }

}