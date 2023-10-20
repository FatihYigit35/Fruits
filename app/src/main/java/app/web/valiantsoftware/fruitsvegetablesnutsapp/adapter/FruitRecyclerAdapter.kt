package app.web.valiantsoftware.fruitsvegetablesnutsapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import app.web.valiantsoftware.fruitsvegetablesnutsapp.databinding.CardDesignFruitBinding
import app.web.valiantsoftware.fruitsvegetablesnutsapp.model.Fruit
import app.web.valiantsoftware.fruitsvegetablesnutsapp.util.createPlaceholder
import app.web.valiantsoftware.fruitsvegetablesnutsapp.util.imageDownload
import app.web.valiantsoftware.fruitsvegetablesnutsapp.view.FruitsFragmentDirections

class FruitRecyclerAdapter(private val fruitList: ArrayList<Fruit>) :
    RecyclerView.Adapter<FruitRecyclerAdapter.FruitViewHolder>() {
    inner class FruitViewHolder(val binding: CardDesignFruitBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val binding =
            CardDesignFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        with(holder) {
            with(binding) {
                fruit = fruitList[position]
                adapter = this@FruitRecyclerAdapter
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun fruitListRefresh(newFruitList: List<Fruit>) {
        fruitList.clear()
        fruitList.addAll(newFruitList)
        notifyDataSetChanged()
    }

    fun gotoFruitDetail(view: View, fruitId: Int) {
        Navigation
            .findNavController(view)
            .navigate(
                FruitsFragmentDirections
                    .actionFruitsFragmentToFruitDetailFragment(fruitId)
            )
    }
}