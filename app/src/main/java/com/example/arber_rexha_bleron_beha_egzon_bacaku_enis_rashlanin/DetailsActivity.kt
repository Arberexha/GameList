package com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.content.Intent
import android.app.AlertDialog

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Initialize views
        val detailsImage = findViewById<ImageView>(R.id.details_image)
        val detailsName = findViewById<TextView>(R.id.details_name)
        val detailsAgeRating = findViewById<TextView>(R.id.details_age_rating)
        val deleteButton = findViewById<Button>(R.id.delete_button)

        // Retrieve data passed from ComplexGameActivity
        val photoResId = intent.getIntExtra("photo", 0)
        val name = intent.getStringExtra("name")
        val ageRating = intent.getStringExtra("ageRating")
        val position = intent.getIntExtra("position", -1)

        // Set the data to views
        if (photoResId != 0) {
            detailsImage.setImageResource(photoResId)
        }
        detailsName.text = name ?: "Game Name Not Available"
        detailsAgeRating.text = "Age Rating: ${ageRating ?: "N/A"}"

        // Delete button functionality with confirmation dialog
        deleteButton.setOnClickListener {
            if (position != -1) {
                // Create the AlertDialog for confirmation
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Delete Game")
                    .setMessage("Are you sure you want to delete ${name}?")
                    .setPositiveButton("Yes") { _, _ ->
                        // If "Yes" is clicked, send result to ComplexGameActivity
                        val resultIntent = Intent()
                        resultIntent.putExtra("delete", true)  // Indicate the game should be deleted
                        resultIntent.putExtra("position", position)  // Pass the position of the game to be deleted
                        setResult(RESULT_OK, resultIntent)  // Set result as OK
                        finish()  // Close the activity and return to the list
                    }
                    .setNegativeButton("No", null)  // If "No" is clicked, just close the dialog
                    .show()  // Show the dialog
            } else {
                Toast.makeText(this, "Failed to delete game.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
