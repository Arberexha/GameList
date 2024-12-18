package com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin




import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.arber_rexha_bleron_beha_egzon_bacaku_enis_rashlanin.models.User

class MainActivity : ComponentActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: AppCompatButton
    private val dummyUsers = listOf(
        User("Arber", "12345678"),
        User("Bleron", "12345678"),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()

        login.setOnClickListener {

            var enteredUsername = username.text.toString()
            var enteredPassword = password.text.toString()
            if (isLoggedIn(enteredUsername, enteredPassword)) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, ComplexGameActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bindViews() {
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
    }

    private fun isLoggedIn(username: String, password: String): Boolean {
        return dummyUsers.any { it.username == username && it.password == password }
    }
}















