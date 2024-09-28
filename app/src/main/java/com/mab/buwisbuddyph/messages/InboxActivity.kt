package com.mab.buwisbuddyph.messages

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mab.buwisbuddyph.R
import com.mab.buwisbuddyph.adapters.MessageListAdapter
import com.mab.buwisbuddyph.dataclass.new_Message

class InboxActivity : AppCompatActivity(), MessageListAdapter.OnRefreshListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var messageAdapter: MessageListAdapter
    private var messages: MutableList<new_Message> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_fragment_inbox)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        recyclerView = findViewById(R.id.recyclerView)
        val backButton: ImageView = findViewById(R.id.back_icon)
        backButton.setOnClickListener {
            finish()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        messageAdapter = MessageListAdapter(messages, this)
        recyclerView.adapter = messageAdapter
    }

    override fun onResume() {
        super.onResume()
        fetchInboxMessages()
    }

    override fun onRequestRefresh() {
        fetchInboxMessages()
    }

    private fun fetchInboxMessages() {
        val currentUserID = auth.currentUser?.uid ?: return

        db.collection("Chats")
            .whereEqualTo("person_1", currentUserID)
            .whereEqualTo("is_trashed", false)
            .get()
            .addOnSuccessListener { chatDocuments ->
                messages.clear()
                for (document in chatDocuments) {
                    val person2ID = document.getString("person_2")
                    if (person2ID != null && person2ID.isNotEmpty()) {
                        db.collection("users").document(person2ID).get().addOnSuccessListener { userDocu ->
                            val avatarImage = userDocu.getString("userProfileImage") ?: ""
                            val fullName = userDocu.getString("userFullName") ?: ""
                            val lastMessage = document.getString("last_message") ?: ""
                            val chatId = document.id
                            val newMessage = new_Message(avatarImage, fullName, lastMessage, chatId)
                            messages.add(newMessage)
                            messageAdapter.notifyDataSetChanged()
                        }
                    }
                }
                messageAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                // Handle error
            }

        db.collection("Chats")
            .whereEqualTo("person_2", currentUserID)
            .whereEqualTo("is_trashed", false)
            .get()
            .addOnSuccessListener { chatDocuments ->
                messages.clear()
                for (document in chatDocuments) {
                    val person1ID = document.getString("person_1")
                    if (person1ID != null && person1ID.isNotEmpty()) {
                        db.collection("users").document(person1ID).get().addOnSuccessListener { userDocu ->
                            val avatarImage = userDocu.getString("userProfileImage") ?: ""
                            val fullName = userDocu.getString("userFullName") ?: ""
                            val lastMessage = document.getString("last_message") ?: ""
                            val chatId = document.id
                            val newMessage = new_Message(avatarImage, fullName, lastMessage, chatId)
                            messages.add(newMessage)
                            messageAdapter.notifyDataSetChanged()
                        }
                    }
                }
                messageAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                // Handle error
            }
    }
}
