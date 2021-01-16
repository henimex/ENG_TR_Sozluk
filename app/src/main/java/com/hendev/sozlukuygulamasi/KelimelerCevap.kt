package com.hendev.sozlukuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KelimelerCevap (@SerializedName("kelimeler") @Expose var kelimeler:List<KelimelerNew>,
                           @SerializedName("success") @Expose var success:Int){
}