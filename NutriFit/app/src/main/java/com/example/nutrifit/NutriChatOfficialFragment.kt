package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*

class NutriChatOfficialFragment : Fragment() {

    private lateinit var recyclerViewChat: RecyclerView
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: Button

    private lateinit var firestore: FirebaseFirestore
    private lateinit var messagesCollection: CollectionReference
    private lateinit var chatAdapter: NutriChatAdapter
    private val chatMessages = mutableListOf<NutriChatMessage>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nutri_chat_official, container, false)

        recyclerViewChat = view.findViewById(R.id.recyclerViewChat)
        editTextMessage = view.findViewById(R.id.editTextMessage)
        buttonSend = view.findViewById(R.id.buttonSend)

        // Set up RecyclerView
        chatAdapter = NutriChatAdapter(chatMessages)
        recyclerViewChat.adapter = chatAdapter
        recyclerViewChat.layoutManager = LinearLayoutManager(requireContext())

        // Initialize Firestore components
        firestore = FirebaseFirestore.getInstance()
        messagesCollection = firestore.collection("NutriFit").document("NutriChat")
            .collection("messages") // Subcollection for messages

        // Listen for new messages
        messagesCollection.orderBy("timestamp", Query.Direction.ASCENDING).addSnapshotListener { snapshot, error ->
            if (error != null) {
                // Handle error
                return@addSnapshotListener
            }

            snapshot?.let {
                chatMessages.clear()
                for (document in it.documents) {
                    val chatMessage = document.toObject(NutriChatMessage::class.java)
                    chatMessage?.let { chatMessages.add(it) }
                }
                chatAdapter.notifyDataSetChanged()
                recyclerViewChat.scrollToPosition(chatMessages.size - 1)
            }
        }

        buttonSend.setOnClickListener {
            sendMessage()
        }

        return view
    }

    private fun sendMessage() {
        val messageText = editTextMessage.text.toString().trim()
        if (messageText.isNotEmpty()) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val messageId = messagesCollection.document().id
            val chatMessage = NutriChatMessage(
                messageId = messageId,
                senderId = currentUser?.uid ?: "",
                senderName = currentUser?.email?.substringBefore('@') ?: "Unknown",
                message = messageText
            )

            messagesCollection.document(messageId).set(chatMessage)
            editTextMessage.text.clear()
        }
    }
}
