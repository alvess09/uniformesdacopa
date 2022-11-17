package alves.ariel.uniformesdacopa.viewModel

import alves.ariel.uniformesdacopa.view.MainActivity
import alves.ariel.uniformesdacopa.model.Team
import alves.ariel.uniformesdacopa.repository.TeamsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: TeamsRepository): MainActivity() {


    fun getAllTeams(){

        val request = this.repository.getAllTeams()

        request.enqueue(object : Callback<List<Team>> {
            override fun onResponse(call: Call<List<Team>>, response: Response<List<Team>>) {
                if(response.isSuccessful) {

                    listTeam = response.body()!!
                }else{
                    this@MainViewModel.errorMessage()
                }
            }

            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                this@MainViewModel.errorMessage()
            }

        })

    }




}



