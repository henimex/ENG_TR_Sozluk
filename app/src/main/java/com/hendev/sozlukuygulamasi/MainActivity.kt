package com.hendev.sozlukuygulamasi

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hendev.retrofitkullanimi.ApiUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var kelimelerListe:ArrayList<KelimelerNew>
    private lateinit var adapter: KelimelerAdapter

    private lateinit var kdi:KelimelerNewDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Sözlük Uygulaması"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        kdi = ApiUtils.getKelimelerDaoInterface()

        tumKelimeler()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.self_search,menu)
        val item = menu?.findItem(R.id.search2)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        //arama yaparken TR değil büyütec isaretini kullan
        aramaYap(query)
        Log.e("Gönderilen Arama",query.toString())
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        aramaYap(newText)
        Log.e("harf girdikçe",newText.toString())
        return true
    }

    fun tumKelimeler(){
        kdi.tumKelimeler().enqueue(object : Callback<KelimelerCevap> {
            override fun onResponse(
                call: Call<KelimelerCevap>?,
                response: Response<KelimelerCevap>?
            ) {
                if (response != null){
                    val liste = response.body().kelimeler
                    adapter = KelimelerAdapter(this@MainActivity,liste)
                    rv.adapter=adapter
                }
            }

            override fun onFailure(call: Call<KelimelerCevap>?, t: Throwable?) {

            }

        })
    }

    fun aramaYap(arananKelime:String){
        kdi.kelimeAra(arananKelime).enqueue(object : Callback<KelimelerCevap> {
            override fun onResponse(
                call: Call<KelimelerCevap>?,
                response: Response<KelimelerCevap>?
            ) {
                if (response != null){
                    val liste = response.body().kelimeler
                    adapter = KelimelerAdapter(this@MainActivity,liste)
                    rv.adapter=adapter
                }
            }

            override fun onFailure(call: Call<KelimelerCevap>?, t: Throwable?) {

            }

        })
    }

}