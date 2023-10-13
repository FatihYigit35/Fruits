package app.web.valiantsoftware.fruits.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import app.web.valiantsoftware.fruits.databinding.CardDesignBinding
import app.web.valiantsoftware.fruits.model.Fruit
import app.web.valiantsoftware.fruits.util.createPlaceholder
import app.web.valiantsoftware.fruits.util.imageDownload
import app.web.valiantsoftware.fruits.view.FruitsFragmentDirections

class FruitRecyclerAdapter(private val fruitList: ArrayList<Fruit>) :
    RecyclerView.Adapter<FruitRecyclerAdapter.FruitViewHolder>() {
    inner class FruitViewHolder(val binding: CardDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val binding: CardDesignBinding =
            CardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        with(holder) {
            with(binding) {
                tvCardFruitName.text = fruitList[position].name
                tvCardFruitDescription.text = fruitList[position].description
                //TODO: görsel eklenecek

                cvFruit.setOnClickListener {
                    gotoFruitDetail(it, 0)
                }

                ivCardFruit.imageDownload(fruitList[position].image, createPlaceholder(holder.itemView.context))
            }
        }
    }

    fun fruitListReflesh(newFruitList: List<Fruit>) {
        fruitList.clear()
        fruitList.addAll(newFruitList)
        notifyDataSetChanged()
    }

    private fun gotoFruitDetail(view: View, fruitId: Int) {
        Navigation
            .findNavController(view)
            .navigate(
                FruitsFragmentDirections
                    .actionFruitsFragmentToFruitDetailFragment(fruitId)
            )
    }

}