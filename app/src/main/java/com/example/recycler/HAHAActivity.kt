package com.example.recycler

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HAHAActivity : AppCompatActivity() {
    /** **/
    // 1. xml 에서 리싸이클러뷰 만들기
    // 2. item 을 위한 xml 레이아웃 만들기
    // 3. item 을 위한 데이터 클래스 만들기
    // 4. [3번] 을 위한 ArrayList 만들기
    // 5. 커스텀 아답터를 만들기
    // 6. 아답터와 데이터를 연결
    // 7. 리싸이클러 뷰와 아답터를 연결

    var editIdx : Int = -1
    var arr : ArrayList<MyItem> = ArrayList()
    lateinit var adapter : HahaRvAdapter
    lateinit var rv : RecyclerView
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hahaactivity)
        rv = findViewById(R.id.rv)
        btn = findViewById(R.id.btn)


        arr.add(MyItem("녕","바보", false))
        arr.add(MyItem("안녕","바보2", false))
        arr.add(MyItem("안녕2","바보", true))
        arr.add(MyItem("안녕2","바보2", false))

        adapter = HahaRvAdapter(this,arr)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        btn.setOnClickListener{
            arr.add(MyItem("str1","str2", false))
            adapter.notifyDataSetChanged()
        }
    }

    class HahaRvAdapter(val context: Context, val arr: ArrayList<MyItem>) :
        RecyclerView.Adapter<HahaRvAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false)
            return Holder(view)
        }

        override fun getItemCount(): Int {
            return arr.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.tv1.setText(arr.get(position).str1)
            holder.tv2.setText(arr.get(position).str2)

            if(arr.get(position).isShow){
                holder.iv.visibility =View.VISIBLE
            }else{
                holder.iv.visibility =View.INVISIBLE
            }

        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var tv1: TextView = itemView!!.findViewById(R.id.tv1)
            val tv2: TextView = itemView!!.findViewById(R.id.tv2)
            val iv: ImageView = itemView!!.findViewById(R.id.iv)
        }
    }




}