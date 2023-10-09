package app.web.valiantsoftware.fruits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.web.valiantsoftware.fruits.databinding.FragmentFruitDetailBinding

class FruitDetailFragment : Fragment() {
    private lateinit var binding: FragmentFruitDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFruitDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

}