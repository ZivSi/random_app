package com.example.randomapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val dataSet: Array<String>, private val imagesArray: Array<Int>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.random_item_name)
            imageView = view.findViewById(R.id.randomItemImageView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.random_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        // Remove \n
        viewHolder.textView.text = dataSet[position]
        viewHolder.imageView.setImageResource(imagesArray[position])

        // Decrease text size for long text
        if (dataSet[position].length > 25) {
            viewHolder.textView.textSize = 10F
        } else if (dataSet[position].length > 26) {
            viewHolder.textView.textSize = 12F
        } else if (dataSet[position].length > 20) {
            viewHolder.textView.textSize = 14F
        } else {
            viewHolder.textView.textSize = 18F
        }

        if (dataSet[position].contains("Blood")) {
            viewHolder.imageView.setColorFilter(Color.RED)
        }

        // If RGB item
        else if (dataSet[position].contains("RGB")) {
            // Get RGB values
            val rgb = viewHolder.textView.text.split("RGB: ")[1].split(", ")
            // Get each value
            val red = rgb[0].toInt()
            val green = rgb[1].toInt()
            val blue = rgb[2].toInt()

            viewHolder.imageView.setColorFilter(
                Color.rgb(red, green, blue), android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
        // If HEX color item
        else if (dataSet[position].contains("Hex")) {
            // Get HEX value
            val hex = dataSet[position].split("Hex: ")[1]
            // Set background color
            viewHolder.imageView.setColorFilter(
                Color.parseColor(hex), android.graphics.PorterDuff.Mode.SRC_IN
            )
        } else {
            // Reset color filter (some icons can be changed too)
            viewHolder.imageView.setColorFilter(Color.BLACK)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}