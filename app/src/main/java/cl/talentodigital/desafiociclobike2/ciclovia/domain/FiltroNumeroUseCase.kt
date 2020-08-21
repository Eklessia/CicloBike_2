package cl.talentodigital.desafiociclobike2.ciclovia.domain

class FiltroNumeroUseCase(
    private val repository: CicloviasRepository
) {
    fun excecute(numero: Int) = repository.filtrarPorNumero(numero)
}