package com.mab.buwisbuddyph.accountant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.mab.buwisbuddyph.R
import com.mab.buwisbuddyph.adapters.AccountantAdapter
import com.mab.buwisbuddyph.dataclass.User
import com.mab.buwisbuddyph.home.HomeActivity

class AccountantHelpActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var accountantAdapter: AccountantAdapter
    private val userList = mutableListOf<User>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accountant_help)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Initialize AccountantAdapter with onItemClick listener
        accountantAdapter = AccountantAdapter(userList) { userID->
            val intent = Intent(this, AccountantProfileActivity::class.java)
            intent.putExtra("userID", userID) // Pass any necessary data to the activity
            startActivity(intent)
        }

        recyclerView.adapter = accountantAdapter

        fetchAccountants()

        val returnIcon = findViewById<ImageView>(R.id.returnIcon)
        returnIcon.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        onBackPressedDispatcher.addCallback(this) {
            val intent = Intent(this@AccountantHelpActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun fetchAccountants() {
        db.collection("users")
            .whereEqualTo("userAccountType", "Accountant")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val user = document.toObject<User>()
                        userList.add(user)
                    }
                    accountantAdapter.notifyDataSetChanged()
                } else {
                    Log.d("AccountantHelpActivity", "Error getting documents: ", task.exception)
                }
            }
    }
}
