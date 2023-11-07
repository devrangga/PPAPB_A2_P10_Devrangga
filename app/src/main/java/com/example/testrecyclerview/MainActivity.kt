package com.example.testrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayListttt: ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageId = arrayOf(
            R.drawable.imgone,
            R.drawable.imgtwo,
            R.drawable.imgthree,
            R.drawable.imgfour,
            R.drawable.imgfive,
            R.drawable.imgsix,
            R.drawable.imgseven,
            R.drawable.imgeight,
            R.drawable.imgnine,
            R.drawable.imgten,
        )

        heading  = arrayOf(
            "Saya suka sekali makan es krim cokelat.",
            "Mobil itu melaju dengan kecepatan tinggi.",
            "Bunga-bunga di kebun itu sangat cantik.",
            "Dia berkata, 'Ayo kita pergi ke bioskop.'",
            "Saat malam tiba, bintang-bintang bersinar terang.",
            "Pada awalnya, cerita ini sangat menarik.",
            "Anjing kesayangan saya selalu setia.",
            "Orang tua saya sering berkata, 'Belajarlah dengan sungguh-sungguh.'",
            "Saya merasa bahagia ketika mendengar berita itu.",
            "Puisi ini memiliki makna yang mendalam.",
        )

        news = arrayOf(
            getString(R.string.news_one),
            getString(R.string.news_two),
            getString(R.string.news_three),
            getString(R.string.news_four),
            getString(R.string.news_five),
            getString(R.string.news_six),
            getString(R.string.news_seven),
            getString(R.string.news_eight),
            getString(R.string.news_nine),
            getString(R.string.news_ten),
        )


        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
//        newRecyclerView.setHasFixedSize(true)

        newArrayListttt = arrayListOf<News>()
        getUserData()
    }
    private fun getUserData() {
        for (i in imageId.indices){
            val news = News(imageId[i],heading[i])
            newArrayListttt.add(news)
        }
        var adapter = MyAdapter(newArrayListttt)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity,NewsActivity::class.java)
                intent.putExtra("heading",newArrayListttt[position].heading)
                intent.putExtra("imageId",newArrayListttt[position].titleImage)
                intent.putExtra("news",news[position])
                startActivity(intent)
            }

        })
    }
}