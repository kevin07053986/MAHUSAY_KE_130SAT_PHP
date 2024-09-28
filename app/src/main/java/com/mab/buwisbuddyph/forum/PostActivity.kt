package com.mab.buwisbuddyph.forum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.mab.buwisbuddyph.R
import com.mab.buwisbuddyph.adapters.CommentListAdapter
import com.mab.buwisbuddyph.dataclass.Comment
import com.mab.buwisbuddyph.dataclass.Post
import com.mab.buwisbuddyph.home.HomeActivity

class PostActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var postTitleTV: TextView
    private lateinit var postContentTV: TextView
    private lateinit var commentEditText: EditText
    private lateinit var commentButton: ImageView
    private lateinit var commentListRV: RecyclerView
    private lateinit var commentListAdapter: CommentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        db = FirebaseFirestore.getInstance()
        postTitleTV = findViewById(R.id.postTitleTV)
        postContentTV = findViewById(R.id.postContentTV)
        commentEditText = findViewById(R.id.commentET)
        commentButton = findViewById(R.id.commentButton)

        commentListRV = findViewById(R.id.commentListRV)
        commentListRV.layoutManager = LinearLayoutManager(this)
        commentListAdapter = CommentListAdapter(mutableListOf())
        commentListRV.adapter = commentListAdapter

        val returnIcon = findViewById<ImageView>(R.id.returnIcon)
        returnIcon.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        onBackPressedDispatcher.addCallback(this) {
            val intent = Intent(this@PostActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val postId = intent.getStringExtra("postId")
        if (postId != null) {
            loadPost(postId)
        }

        commentButton.setOnClickListener {
            val commentText = commentEditText.text.toString()
            if (commentText.isNotEmpty()) {
                val comment = Comment(
                    commentID = "",
                    commentUserID = FirebaseAuth.getInstance().currentUser?.uid ?: "",
                    commentUserComment = commentText,
                    commentTimestamp = Timestamp.now()
                )

                if (postId != null) {
                    db.collection("posts").document(postId).collection("comments").add(comment)
                        .addOnSuccessListener { documentReference ->
                            documentReference.update("commentID", documentReference.id)
                                .addOnSuccessListener {
                                    println("Comment successfully written!")
                                }
                                .addOnFailureListener { e ->
                                    Log.e("PostActivity", "Error updating comment ID", e)
                                }
                        }
                        .addOnFailureListener { e ->
                            Log.e("PostActivity", "Error writing comment: $e")
                        }
                }

                commentEditText.text.clear()
            }
        }
    }

    private fun loadPost(postId: String) {
        db.collection("posts").document(postId)
            .get()
            .addOnSuccessListener { document ->
                val post = document.toObject(Post::class.java)
                if (post != null) {
                    postTitleTV.text = post.postTitle
                    postContentTV.text = post.postContent

                    db.collection("posts").document(postId).collection("comments")
                        .orderBy("commentTimestamp")
                        .addSnapshotListener { commentDocuments, _ ->
                            commentDocuments?.let { snapshot ->
                                val comments = snapshot.documents.mapNotNull { commentDocument ->
                                    commentDocument.toObject(Comment::class.java)
                                }
                                commentListAdapter.updateData(comments)
                                commentListRV.scrollToPosition(comments.size - 1)
                            }
                        }
                }
            }
            .addOnFailureListener { exception ->
                Log.e("PostActivity", "Error getting post", exception)
            }
    }

}
