package cl.talentodigital.desafiociclobike2.ciclovia.domain

class FiltroTextoUseCase(
    private val repository: CicloviasRepository
) {
    fun excecute(texto: String) = repository.filtrarPorTexto(texto)
}