package com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.R
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.models.Game

class GameAdapter(private val context: Context, private val gameList: List<Game>) : BaseAdapter() {
    override fun getCount(): Int = gameList.size

    override fun getItem(position: Int): Any = gameList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_layout, parent, false)
        val game = gameList[position]

        val gameImage = view.findViewById<ImageView>(R.id.game_image)
        val gameName = view.findViewById<TextView>(R.id.game_name)
        val gameAgeRating = view.findViewById<TextView>(R.id.game_age_rating)

        gameImage.setImageResource(game.photo)
        gameName.text = game.name
        gameAgeRating.text = "Age Rating: ${game.ageRating}"

        return view
    }
}
