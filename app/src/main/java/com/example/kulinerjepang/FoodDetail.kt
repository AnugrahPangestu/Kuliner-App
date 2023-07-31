package com.example.kulinerjepang

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodDetail : AppCompatActivity() {

    private lateinit var imgView: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvDecs: TextView
    private lateinit var tvReceipt:TextView
    private lateinit var tvReceiptDecs:TextView

    companion object{
        const val EXTRA_PERSON = "key_food"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)
        supportActionBar?.hide()

        //val dataName = resources.getStringArray(R.array.data_name)
        //val dataDescription = resources.getStringArray(R.array.data_description)
        //val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        //val dataReceipt = resources.getStringArray(R.array.data_receipt)
        //val dataReceiptDecs = resources.getStringArray(R.array.data_receipt_decs)

       // for (i in dataReceipt.indices) {
        //    val food = Food(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataReceipt[i], dataReceiptDecs[i])
         //   food
        //}

        imgView = findViewById(R.id.img_product_detail)
        tvTitle = findViewById(R.id.tv_title_detail)
        tvDecs = findViewById(R.id.tv_decs_detail)
        tvReceipt = findViewById(R.id.tv_receipt_detail)
        tvReceiptDecs = findViewById(R.id.tv_make_decs_detail)

        val food = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>(EXTRA_PERSON, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>(EXTRA_PERSON)
        }

        if(food != null) {
            imgView.setImageResource(food.photo)
            Log.d("tes_lagi", food.toString())
            tvTitle.text = food.name
            tvDecs.text = food.description
            tvReceipt.text = food.receipt
            tvReceiptDecs.text = food.receiptDecs

        }
    }
}