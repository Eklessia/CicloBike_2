package cl.talentodigital.desafiociclobike2.ciclovia.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.desafiociclobike2.ciclovia.data.local.CicloviasLocalRepository
import cl.talentodigital.desafiociclobike2.ciclovia.domain.model.Ciclovia
import cl.talentodigital.desafiociclobike2.R
import cl.talentodigital.desafiociclobike2.ciclovia.domain.*
import cl.talentodigital.desafiociclobike2.databinding.FragmentCicloviasBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CicloviasFragment : Fragment(R.layout.fragment_ciclovias) {

    private lateinit var binding: FragmentCicloviasBinding
    private lateinit var cicloviasAdapter: CicloviasAdapter
    private lateinit var filtroLasCondesUseCase: FiltroLasCondesUseCase
    private lateinit var obtenerCicloviasUseCase: ObtenerCicloviasUseCase
    private lateinit var filtroTextoUseCase: FiltroTextoUseCase
    private lateinit var filtroNumeroUseCase: FiltroNumeroUseCase
    private lateinit var repository: CicloviasRepository
    private val compositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        callUseCaseObtener()
        bindView(view)
        setupRecivlerView()
        setupListeners()
    }

    private fun setupDependencies() {
        repository = CicloviasLocalRepository()
        filtroLasCondesUseCase = FiltroLasCondesUseCase(repository)
        obtenerCicloviasUseCase = ObtenerCicloviasUseCase(repository)
        filtroTextoUseCase = FiltroTextoUseCase(repository)
        filtroNumeroUseCase = FiltroNumeroUseCase(repository)
    }

    private fun callUseCaseLasCondes() {
        compositeDisposable.add(filtroLasCondesUseCase.excecute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> handleReult(result) },
                { error -> handleError(error) }
            )
        )
    }

    private fun callUseCaseObtener() {
        compositeDisposable.add(obtenerCicloviasUseCase.excecute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> handleReult(result) },
                { error -> handleError(error) }
            )
        )
    }

    private fun callUseCaseFiltroTexto() {
        compositeDisposable.add(filtroTextoUseCase.excecute(binding.edFiltroTexto.text.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> handleReult(result) },
                { error -> handleError(error) }
            )
        )
    }

    private fun callUseCaseNumero() {
        compositeDisposable.add(filtroNumeroUseCase.excecute(
            binding.edFiltroNumero.text.toString().toInt()
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> handleReult(result) },
                { error -> handleError(error) }
            )
        )
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(
            requireContext(),
            "Error {${error.message}}",
            Toast.LENGTH_LONG
        )
            .show()
    }

    private fun handleReult(result: List<Ciclovia>) {
        cicloviasAdapter = CicloviasAdapter(result)
        binding.rvCiclovias.adapter = cicloviasAdapter
    }

    private fun bindView(view: View) {
        binding = FragmentCicloviasBinding.bind(view)
    }

    private fun setupRecivlerView() {
        binding.apply {
            rvCiclovias.setHasFixedSize(true)
            rvCiclovias.layoutManager = LinearLayoutManager(
                requireContext()
            )
            rvCiclovias.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun setupListeners() {
        binding.apply {
            btnFiltroLasCondes.setOnClickListener {
                callUseCaseLasCondes()
            }


            btnQuitarFiltro.setOnClickListener {
                callUseCaseObtener()
            }


            btnBuscarTexto.setOnClickListener {
                if (edFiltroTexto.text.toString().isNotEmpty()) {
                    callUseCaseFiltroTexto()
                }
            }

            btnBuscarNumero.setOnClickListener {
                if (edFiltroNumero.text.toString().isNotEmpty()) {
                    callUseCaseNumero()
                }
            }
        }
    }
}