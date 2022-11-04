package alves.ariel.uniformesdacopa.repository

import alves.ariel.uniformesdacopa.api.RetrofitService

class TeamsRepository(private val retrofitService: RetrofitService) {

    fun getAllTeams() = retrofitService.getAllTeams()

}