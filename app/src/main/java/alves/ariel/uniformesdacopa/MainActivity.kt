package alves.ariel.uniformesdacopa

import alves.ariel.uniformesdacopa.databinding.ActivityMainBinding
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
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

        val adapter = ArrayAdapter(this, R.layout.list_teams , items)
        binding.tvItems.setAdapter(adapter)

    }


}
