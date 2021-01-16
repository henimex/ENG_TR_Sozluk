package com.hendev.sozlukuygulamasi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class KelimelerNew(
    @SerializedName("kelime_id") @Expose var kelime_id: Int,
    @SerializedName("ingilizce") @Expose var ingilizce: String,
    @SerializedName("turkce") @Expose var turkce: String
) : Serializable {
}