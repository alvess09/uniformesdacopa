package alves.ariel.uniformesdacopa.view

import alves.ariel.uniformesdacopa.R
import alves.ariel.uniformesdacopa.databinding.ActivityMainBinding
import alves.ariel.uniformesdacopa.model.Team
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

open class MainActivity : AppCompatActivity() {
    var listTeam : List<Team> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setItemsList()


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentTeams>(R.id.fragmentContainerView)
            }
        }


        //val service : RetrofitService = retrofit.create(RetrofitService.class)
    }

    private fun setItemsList() {

        val items = listOf(
            "Alemanha",
            "Arábia Saudita",
            "Argentina",
            "Austrália",
            "Bélgica",
            "Brasil",
            "Camarões",
            "Canadá",
            "Coreia do Sul",
            "Costa Rica",
            "Croácia",
            "Dinamarca",
            "Equador",
            "Espanha",
            "Eua",
            "França",
            "Gana",
            "Holanda",
            "Inglaterra",
            "Irã",
            "Japão",
            "Marrocos",
            "México",
            "País De Gales",
            "Polônia",
            "Portugal",
            "Qatar",
            "Senegal",
            "Sérvia",
            "Suíça",
            "Tunísia",
            "Uruguai"
        )
        val adapter = ArrayAdapter(this, R.layout.list_teams, items)
        binding.tvItems.setAdapter(adapter)




    }
    fun errorMessage(){
        val messageError = "Failure In request!"
        Toast.makeText(this@MainActivity, messageError, Toast.LENGTH_SHORT).show()
    }


}
