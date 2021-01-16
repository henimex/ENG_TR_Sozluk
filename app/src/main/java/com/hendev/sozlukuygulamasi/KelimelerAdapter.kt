package com.hendev.sozlukuygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KelimelerAdapter(private val mContext: Context, private val kelimelerListe: List<KelimelerNew>)
    : RecyclerView.Adapter<KelimelerAdapter.tasarimTutucu>() {

    inner class tasarimTutucu (x:View): RecyclerView.ViewHolder(x) {

        var kelime_card : CardView
        var txtEng : TextView
        var txtTR : TextView

        init {
            kelime_card = x.findViewById(R.id.kelime_card)
            txtEng = x.findViewById(R.id.txtEng)
            txtTR = x.findViewById(R.id.txtTR)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tasarimTutucu {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim,parent,false)
        return tasarimTutucu(design)
    }

    override fun onBindViewHolder(holder: tasarimTutucu, position: Int) {
        val kelime = kelimelerListe[position]

        holder.txtEng.text = kelime.ingilizce
        holder.txtTR.text = kelime.turkce

        holder.kelime_card.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("nesne",kelime)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kelimelerListe.size
    }

}