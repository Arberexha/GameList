package com.cacttus.android_gr2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.DetailsActivity
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.R
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.adapters.GameAdapter
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.models.Game

class GameListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.complex_list)

        val gameListView = findViewById<ListView>(R.id.complex_list)

        // List of games
        val gameList = listOf(
            Game(R.drawable.minecraft, "Minecraft", "10+"),
            Game(R.drawable.fortnite, "Fortnite", "12+"),
            Game(R.drawable.pubg, "PUBG Mobile", "16+"),
            Game(R.drawable.img, "Call of Duty", "18+"),
            Game(R.drawable.img_1, "GTA V", "18+"),
            Game(R.drawable.img_2, "FIFA 24", "3+"),
            Game(R.drawable.img_3, "Rocket League", "10+"),
            Game(R.drawable.img_4, "Valorant", "16+"),
            Game(R.drawable.img_5, "Elden Ring", "18+"),
            Game(R.drawable.img_5, "League of Legends", "12+")
        )

        // Adapter for games
        val gameAdapter = GameAdapter(this, gameList)

        gameListView.adapter = gameAdapter

        // Item click listener for each game
        gameListView.setOnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(
                this, "${gameList[position].name} is selected",
                Toast.LENGTH_LONG
            ).show()

            // Passing data to DetailsActivity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("photo", gameList[position].photo)
            intent.putExtra("name", gameList[position].name)
            intent.putExtra("ageRating", gameList[position].ageRating)
            startActivity(intent)
        }
    }
}
