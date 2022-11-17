package alves.ariel.uniformesdacopa.view

import alves.ariel.uniformesdacopa.databinding.ActivityFragmentsTeamsBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentTeams : Fragment() {
    private var _binding: ActivityFragmentsTeamsBinding? = null
    private val binding: ActivityFragmentsTeamsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityFragmentsTeamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //criar funções para os botões
        binding.btnUniform1.setOnClickListener {
           // TODO("Inserir request de uniforme 1 do time")
        }
        binding.btnUniform2.setOnClickListener {
           // TODO("inserir request uniforme 2 do time")
        }

        //configurar um request padrão setando uniforme 1 como padrão a ser alterado quando clicado
        // nos botões de iteração

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}