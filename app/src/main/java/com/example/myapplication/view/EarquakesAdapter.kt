package com.example.myapplication.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AppConstant
import com.example.myapplication.R
import com.example.myapplication.model.Earthquakes
import kotlinx.android.synthetic.main.list_items.view.*

@SuppressLint("StringFormatInvalid")
class MyRecycleViewAdapter ( val list: MutableList<Earthquakes>) :
    RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model: Earthquakes = list[position]
        holder.textViewDate.text = holder.resource.getString(R.string.str_date_time, model.datetime)
        holder.textViewDept.text =
            holder.resource.getString(R.string.str_depth, model.depth.toString())
        holder.textViewMagnitude.apply {
            text = holder.resource.getString(R.string.str_magnitude, model.magnitude.toString())
            if (model.magnitude >= 8.0) {
                setTextColor(Color.RED)
                typeface = Typeface.DEFAULT_BOLD
            }
        }
        holder.parentLayout.also {
            it.setOnClickListener{
                    view -> val bundle = bundleOf(AppConstant.LAT to model.lat.toFloat() , AppConstant.LNG to model.lng.toFloat() )
                view.findNavController()
                    .navigate(R.id.action_homeFragment_to_mapsFragment, bundle)
            }
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewDate = itemView.str_date
        val textViewMagnitude = itemView.str_magnitude
        val textViewDept = itemView.str_dept
        val resource = itemView.context.resources
        val parentLayout = itemView.parent_layout
    }

}