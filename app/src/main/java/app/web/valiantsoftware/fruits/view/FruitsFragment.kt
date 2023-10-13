package app.web.valiantsoftware.fruits.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.web.valiantsoftware.fruits.adapter.FruitRecyclerAdapter
import app.web.valiantsoftware.fruits.databinding.FragmentFruitsBinding
import app.web.valiantsoftware.fruits.viewmodel.FruitsViewModel

class FruitsFragment : Fragment() {
    private lateinit var binding: FragmentFruitsBinding
    private lateinit var viewModel: FruitsViewModel
    private val recyclerAdapter = FruitRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FruitsViewModel::class.java)
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

        viewModel.refreshData()

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = recyclerAdapter

            swiperefreshlayout.setOnRefreshListener {
                progressBar.visibility = View.VISIBLE
                textViewError.visibility = View.GONE
                recyclerView.visibility = View.GONE
                viewModel.refreshData()
                swiperefreshlayout.isRefreshing = false
            }
        }

        observeLiveData()

    }

    private fun observeLiveData() {
        with(viewModel) {
            with(binding) {
                fruitsLiveData.observe(viewLifecycleOwner) {
                    it?.let {
                        recyclerView.visibility = View.VISIBLE
                        recyclerAdapter.fruitListReflesh(it)
                    }
                }

                errorMessageLiveData.observe(viewLifecycleOwner) {
                    it?.let {
                        if (it) {
                            recyclerView.visibility = View.GONE
                            progressBar.visibility = View.GONE
                            textViewError.visibility = View.VISIBLE
                        } else {
                            textViewError.visibility = View.GONE
                        }
                    }
                }

                progressBarLiveData.observe(viewLifecycleOwner) {
                    it?.let {
                        if (it) {
                            recyclerView.visibility = View.GONE
                            textViewError.visibility = View.GONE
                            progressBar.visibility = View.VISIBLE
                        } else {
                            progressBar.visibility = View.GONE
                        }
                    }
                }

            }
        }


    }


}