package com.hendev.retrofitkullanimi

import com.hendev.sozlukuygulamasi.KelimelerNewDaoInterface

class ApiUtils {
    companion object{
        val BASE_URL = "https://jhenimex.000webhostapp.com/"
        fun getKelimelerDaoInterface():KelimelerNewDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KelimelerNewDaoInterface::class.java)
        }
    }
}