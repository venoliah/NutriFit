package com.example.nutrifit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutrifit.databinding.ItemChatUserBinding
import com.example.nutrifit.databinding.ItemChatOtherBinding
import com.google.firebase.auth.FirebaseAuth

class NutriChatAdapter(private val chatMessages: List<NutriChatMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_USER = 1
    private val VIEW_TYPE_OTHER = 2

    override fun getItemViewType(position: Int): Int {
        val message = chatMessages[position]
        return if (message.senderId == FirebaseAuth.getInstance().currentUser?.uid) {
            VIEW_TYPE_USER
        } else {
            VIEW_TYPE_OTHER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_USER -> {
                val binding = ItemChatUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                UserViewHolder(binding)
            }
            VIEW_TYPE_OTHER -> {
                val binding = ItemChatOtherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                OtherViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chatMessage = chatMessages[position]
        when (holder) {
            is UserViewHolder -> holder.bind(chatMessage)
            is OtherViewHolder -> holder.bind(chatMessage)
        }
    }

    override fun getItemCount(): Int = chatMessages.size

    inner class UserViewHolder(private val binding: ItemChatUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(message: NutriChatMessage) {
            binding.profileCircle.text = message.senderName.first().toString().uppercase()
            binding.profileEmail.text = message.senderName
            binding.textMessage.text = message.message

            // Align user's messages to the right
            val layoutParams = binding.root.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.marginStart = 0
            layoutParams.marginEnd = 16.dpToPx(binding.root.context)
            binding.root.layoutParams = layoutParams
            binding.root.gravity = android.view.Gravity.END
        }
    }

    inner class OtherViewHolder(private val binding: ItemChatOtherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(message: NutriChatMessage) {
            binding.profileCircle.text = message.senderName.first().toString().uppercase()
            binding.profileEmail.text = message.senderName
            binding.textMessage.text = message.message

            // Align others' messages to the left
            val layoutParams = binding.root.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.marginStart = 16.dpToPx(binding.root.context)
            layoutParams.marginEnd = 0
            binding.root.layoutParams = layoutParams
            binding.root.gravity = android.view.Gravity.START
        }
    }

    private fun Int.dpToPx(context: android.content.Context): Int {
        val density = context.resources.displayMetrics.density
        return (this * density).toInt()
    }
}
