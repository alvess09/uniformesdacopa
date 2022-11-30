package alves.ariel.uniformesdacopa.viewModel

import alves.ariel.uniformesdacopa.view.MainActivity
import alves.ariel.uniformesdacopa.model.Team
import alves.ariel.uniformesdacopa.repository.TeamsRepository
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response as Response1

class MainViewModel constructor(private val repository: TeamsRepository): MainActivity() {


    fun getAllTeams(){

        val request = this.repository.getAllTeams()
        var listTeam: List<Team>? = null

        request.enqueue(object : Callback<List<Team>> {
            override fun onResponse(call: Call<List<Team>>, response: Response1<List<Team>>) {
                if(response.isSuccessful) {

                    listTeam = (response.body() as Nothing?)!!
                }else{
                    this@MainViewModel.errorMessage()
                }
            }

            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                this@MainViewModel.errorMessage()
            }

        })

    }

    private fun errorMessage() {
        val message =  "Error in request "
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}



