package cl.talentodigital.desafiociclobike2.ciclovia.domain

class FiltroLasCondesUseCase(
    private val repository: CicloviasRepository
) {
    fun excecute() = repository.filtrarLasCondes()
}