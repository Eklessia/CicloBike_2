package cl.talentodigital.desafiociclobike2.ciclovia.domain

import cl.talentodigital.desafiociclobike2.ciclovia.domain.model.Ciclovia
import io.reactivex.Single

interface CicloviasRepository {
    fun obtenerCiclovias(): Single<List<Ciclovia>>
    fun filtrarLasCondes(): Single<List<Ciclovia>>
    fun filtrarPorTexto(texto: String): Single<List<Ciclovia>>
    fun filtrarPorNumero(numero: Int): Single<List<Ciclovia>>
}