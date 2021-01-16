package com.hendev.sozlukuygulamasi

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KelimelerNewDaoInterface {
    @GET("services/tum_kelimeler.php")
    fun tumKelimeler():Call<KelimelerCevap>
    @POST ("services/tum_kelimeler_ara.php")
    @FormUrlEncoded
    fun kelimeAra(@Field("ingilizce") ingilizce:String) : Call<KelimelerCevap>
}