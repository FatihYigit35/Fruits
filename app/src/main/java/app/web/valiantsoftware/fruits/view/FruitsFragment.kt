package app.web.valiantsoftware.fruits.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import app.web.valiantsoftware.fruits.databinding.FragmentFruitsBinding

class FruitsFragment : Fragment() {
    private lateinit var binding: FragmentFruitsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFruitsBinding.inflate(inflater, container, false)
        binding.fruitsFragment = this@FruitsFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

        }
    }

    fun gotoFruitDetail(view: View, fruitId: String) {
        val id = Integer.parseInt(fruitId)
        Navigation.findNavController(view)
            .navigate(FruitsFragmentDirections.actionFruitsFragmentToFruitDetailFragment(id))
    }
}