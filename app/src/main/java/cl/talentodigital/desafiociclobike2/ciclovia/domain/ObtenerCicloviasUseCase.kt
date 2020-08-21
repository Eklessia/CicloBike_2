package cl.talentodigital.desafiociclobike2.ciclovia.domain

class ObtenerCicloviasUseCase(
    private val repository: CicloviasRepository
) {
    fun excecute() = repository.obtenerCiclovias()
}