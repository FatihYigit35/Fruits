package app.web.valiantsoftware.fruits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }
}