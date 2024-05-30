package com.mab.buwisbuddyph.adapters

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.mab.buwisbuddyph.R
import com.mab.buwisbuddyph.messages.ChatActivity
import com.mab.buwisbuddyph.dataclass.new_Message
import de.hdodenhof.circleimageview.CircleImageView

class MessageListAdapter2(private val messages: List<new_Message>, private val refreshListener: OnRefreshListener) : RecyclerView.Adapter<MessageListAdapter2.MessageViewHolder>() {

    interface OnRefreshListener {
        fun onRequestRefresh()
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: CircleImageView = itemView.findViewById(R.id.circleImageView)
        val userFullName: TextView = itemView.findViewById(R.id.fullNameTextView)
        val lastMessage: TextView = itemView.findViewById(R.id.lastChatTextView)
        val layout: LinearLayout = itemView.findViewById(R.id.layoutMain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]

        // Set data to views
        holder.userFullName.text = message.fullName
        holder.lastMessage.text = message.last_chat
        holder.layout.setOnClickListener {
            // Open ChatActivity and pass chatId as an argument
            val context = holder.itemView.context
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("chatID", message.chatId)
            context.startActivity(intent)
        }
        holder.layout.setOnLongClickListener {
            showDeleteConfirmationDialog(holder.itemView.context, message)
            true // Return true to consume the long click event
        }

        // Load profile image with Glide
        Glide.with(holder.itemView.context)
            .load(if (message.avatarUrl.isEmpty()) R.drawable.default_profile_img else message.avatarUrl)
            .into(holder.profileImage)
    }

    override fun getItemCount() = messages.size

    private fun showDeleteConfirmationDialog(context: Context, message: new_Message) {
        val updateData = hashMapOf<String, Any>(
            "is_trashed" to false
        )
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle("Retrieve Message")
        alertDialogBuilder.setMessage("Are you sure you want to retrieve this message?")
        alertDialogBuilder.setPositiveButton("Retrieve") { dialogInterface: DialogInterface, _: Int ->
            FirebaseFirestore.getInstance().collection("Chats").document(message.chatId).update(updateData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Message retrieved", Toast.LENGTH_SHORT).show()
                    dialogInterface.dismiss()
                    refreshListener.onRequestRefresh()
                }
        }
        alertDialogBuilder.setNegativeButton("Cancel") { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
