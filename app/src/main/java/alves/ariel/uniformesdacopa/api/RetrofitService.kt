package alves.ariel.uniformesdacopa.api

import alves.ariel.uniformesdacopa.model.Team
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("teams.json")
    fun getAllTeams() : Call<List<Team>>


    companion object{
        private val retrofitService : RetrofitService by lazy {
            val retrofitService = Retrofit.Builder()
                .baseUrl("https://alvess09.github.io/copa-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return@lazy retrofitService.create(RetrofitService::class.java)
        }
        fun getInstance(): RetrofitService{
            return retrofitService
        }

    }



}