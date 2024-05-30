package com.mab.buwisbuddyph.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mab.buwisbuddyph.R
import com.mab.buwisbuddyph.dataclass.new_Message
import com.mab.buwisbuddyph.messages.ChatActivity
import de.hdodenhof.circleimageview.CircleImageView

class MessageListAdapter3(private val messages: List<new_Message>) : RecyclerView.Adapter<MessageListAdapter3.MessageViewHolder>() {

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

        // Set profile image (you need to load the image here if you have a URL or resource ID)
        // holder.profileImage.setImageDrawable(...)
    }

    override fun getItemCount() = messages.size
}
