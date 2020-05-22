package com.example.goapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.active_page.*

class ActivePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.active_page)
        val items = ArrayList<ItemModel>()
        fun init(){
        }
        DataLoader.getRequest("europeanCountries", object : CustomCallback {
            override fun onSuccess(result: String){

                val Serialized = Gson().fromJson(
                    result,
                    Serializer::class.java
                )
                 val item = Serialized.results
                items.add(ItemModel(R.mipmap.albania, "ალბანეთი", "საწვავის ფასი (EU)" , item[0].gasoline))
                items.add(ItemModel(R.mipmap.algeria, "ალგერია", "საწვავის ფასი (EU)", item[1].gasoline ))
                items.add(ItemModel(R.mipmap.andorra, "ანდორა", "საწვავის ფასი (EU)", item[2].gasoline))
                items.add(ItemModel(R.mipmap.armenia, "სომხეთი", "საწვავის ფასი (EU)",  item[3].gasoline))
                recyclerview.layoutManager = LinearLayoutManager(this@ActivePage)
                recyclerview.adapter = RecyclerViewAdapter(items)
            }
        } )
        init()
    }
}
