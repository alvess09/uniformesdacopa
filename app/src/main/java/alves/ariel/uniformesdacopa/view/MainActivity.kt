package alves.ariel.uniformesdacopa.view

import alves.ariel.uniformesdacopa.R
import alves.ariel.uniformesdacopa.databinding.ActivityMainBinding
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import java.lang.reflect.Field

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

open class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentTeams>(R.id.fragmentContainerView)
            }
        }


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

        //binding.tvItems.setAdapter(adapter)

        with(binding.tvItems){
            setAdapter(adapter)

            //implementa o listener do item selecionado
            onItemClickListener = this@MainActivity
        }








     /*   binding.tvItems.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = items[position]
                Toast.makeText(this@MainActivity, "selecionado: $item", Toast.LENGTH_SHORT).show()


                var selectedTeam = ""

                when(item){
                    "Alemanha" -> {
                        "alemanha".also { selectedTeam = it }
                    }
                    "Arábia Saudita" -> {
                        "arabiasaudita".also { selectedTeam = it }
                    }
                    "Argentina" -> {
                        "argentina".also { selectedTeam = it }
                    }
                    "Austrália" ->{
                        "australia".also { selectedTeam = it }
                    }
                    "Bélgica" ->{
                        "belgica".also { selectedTeam = it }
                    }
                    "Brasil" -> {
                        "brasil".also { selectedTeam = it }
                    }
                    "Camarões" -> {
                        "camaroes".also { selectedTeam = it }
                    }
                    "Canadá" -> {
                        "canada".also { selectedTeam = it }
                    }
                    "Coreia do Sul" -> {
                        "coreiadosul".also { selectedTeam = it }
                    }
                    "Costa Rica" -> {
                        "costarica".also { selectedTeam = it }
                    }
                    "Croácia" -> {
                        "croacia".also { selectedTeam = it }
                    }
                    "Dinamarca"-> {
                        "dinamarca".also { selectedTeam = it }
                    }
                    "Equador"-> {
                        "equador".also { selectedTeam = it }
                    }
                    "Espanha"-> {
                        "espanha".also { selectedTeam = it }
                    }
                    "Eua"-> {
                        "eua".also { selectedTeam = it }
                    }
                    "França"-> {
                        "franca".also { selectedTeam = it }
                    }
                    "Gana"-> {
                        "gana".also { selectedTeam = it }
                    }
                    "Holanda"-> {
                        "holanda".also { selectedTeam = it }
                    }
                    "Inglaterra"-> {
                        "inglaterra".also { selectedTeam = it }
                    }
                    "Irã"-> {
                        "ira".also { selectedTeam = it }
                    }
                    "Japão"-> {
                        "japao".also { selectedTeam = it }
                    }
                    "Marrocos"-> {
                        "marrocos".also { selectedTeam = it }
                    }
                    "México"-> {
                        "mexico".also { selectedTeam = it }
                    }
                    "País De Gales"-> {
                        "paisdegales".also { selectedTeam = it }
                    }
                    "Polônia"-> {
                        "polonia".also { selectedTeam = it }
                    }
                    "Portugal"-> {
                        "portugal".also { selectedTeam = it }
                    }
                    "Qatar"-> {
                        "qatar".also { selectedTeam = it }
                    }
                    "Senegal"-> {
                        "senegal".also { selectedTeam = it }
                    }
                    "Sérvia"-> {
                        "servia".also { selectedTeam = it }
                    }
                    "Suíça"-> {
                        "suica".also { selectedTeam = it }
                    }
                    "Tunísia"-> {
                        "tunisia".also { selectedTeam = it }
                    }
                    "Uruguai"-> {
                        "uruguai".also { selectedTeam = it }
                    }


                }



            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }

        }*/

        limitDropdownHeight(binding.tvItems)


        // TODO("verificar o item selecionado do menu e de acordo com a seleção requisitar o objeto da API equivalente")
       // val itemSelected = selectedTeam
    }

    // escuta o item selecionado da lista
    override fun onItemClick (parent: AdapterView<*>?, view: View?, position: Int, id: Long){

        val item = parent?.getItemAtPosition(position).toString()
        //Passar dados do item selecionado pela intent usando .putExtra
        // val intent = Intent(this)
        Toast.makeText(this@MainActivity, item, Toast.LENGTH_SHORT).show()
    }

    //define tamanho da listagem do menu dropdown
    @SuppressLint("DiscouragedPrivateApi")
    fun limitDropdownHeight(tvItems: AutoCompleteTextView){

        val popup: Field = AutoCompleteTextView::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val popupWindow = popup.get(tvItems) as ListPopupWindow
        popupWindow.height = (200 * resources.displayMetrics.density).toInt()


    }

}















