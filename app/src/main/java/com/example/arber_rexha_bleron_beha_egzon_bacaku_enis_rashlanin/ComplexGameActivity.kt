package com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.adapters.GameAdapter
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.models.Game

class ComplexGameActivity : ComponentActivity() {
    private lateinit var gameList: MutableList<Game>
    private lateinit var gameAdapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.complex_list)

        val gameListView = findViewById<ListView>(R.id.complex_list)

        // Initialize the game list
        gameList = mutableListOf(
            Game(R.drawable.minecraft, "Minecraft", "10+"),
            Game(R.drawable.fortnite, "Fortnite", "12+"),
            Game(R.drawable.pubg, "PUBG Mobile", "16+"),
            Game(R.drawable.img, "Call of Duty", "18+"),
            Game(R.drawable.img_1, "GTA V", "18+"),
            Game(R.drawable.img_2, "FIFA 24", "3+"),
            Game(R.drawable.img_3, "Rocket League", "10+"),
            Game(R.drawable.img_4, "Valorant", "16+"),
            Game(R.drawable.img_5, "Elden Ring", "18+"),
            Game(R.drawable.img_6, "League of Legends", "12+")
        )

        // Adapter for games
        gameAdapter = GameAdapter(this, gameList)
        gameListView.adapter = gameAdapter

        // Item click listener for each game
        gameListView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("photo", gameList[position].photo)
            intent.putExtra("name", gameList[position].name)
            intent.putExtra("ageRating", gameList[position].ageRating)
            startActivityForResult(intent, 1001) // Pass a request code for identifying the result
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1001 && resultCode == RESULT_OK) {
            val shouldDelete = data?.getBooleanExtra("delete", false) ?: false
            val position = data?.getIntExtra("position", -1) ?: -1

            if (shouldDelete && position != -1) {
                // Remove the game from the list and refresh the adapter
                gameList.removeAt(position)
                gameAdapter.notifyDataSetChanged() // Refresh the ListView
                Toast.makeText(this, "Game deleted successfully.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to delete game.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
