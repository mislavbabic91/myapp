package com.example.podcastland

import PodcastAdapter
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.podcastland.data.Podcast
import com.example.podcastland.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var podcastAdapter: PodcastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.podcastList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        getUserData()
        setupLinkButton1()
        setupLinkButton2()
        setupLinkButton3()
        setupLinkButton4()

    }

    private fun getUserData() {
        FirebaseFirestore.getInstance().collection("Podcast")
            .get()
            .addOnSuccessListener {documents->
                for(document in documents){
                    val user = documents.toObjects(Podcast::class.java)
                    binding.podcastList.adapter = PodcastAdapter(this, user)
                }

            }
    }

    fun setupLinkButton1() {
        val linkButton = findViewById<Button>(R.id.button1)
        linkButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/podcast-app-54b41.appspot.com/o/Elon%20Musk%2C%20Lex%20Fridman%20Podcast.mp3?alt=media&token=4def56e3-be0e-49d5-9054-33151664918a"))
            startActivity(browserIntent)
        }
    }
    fun setupLinkButton2() {
        val linkButton = findViewById<Button>(R.id.button2)
        linkButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/podcast-app-54b41.appspot.com/o/Michio%20Kaku%2C%20Lex%20Fridman%20Podcast.mp3?alt=media&token=2705f105-8071-4b0d-9d27-7534626a2b89"))
            startActivity(browserIntent)
        }
    }
    fun setupLinkButton3() {
        val linkButton = findViewById<Button>(R.id.button3)
        linkButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/podcast-app-54b41.appspot.com/o/Dave%20Grohl%2C%20The%20Bill%20Simmons%20Podcast.mp3?alt=media&token=2f3bbea3-8b58-4391-9eda-45e02921c1f8"))
            startActivity(browserIntent)
        }
    }
    fun setupLinkButton4() {
        val linkButton = findViewById<Button>(R.id.button4)
        linkButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/podcast-app-54b41.appspot.com/o/Nogometni%20Podcast%20-%20Anton%20Samovojska.mp3?alt=media&token=be73a1bc-592b-45b7-a01a-c2f6ddbd3c53"))
            startActivity(browserIntent)
        }
    }
}