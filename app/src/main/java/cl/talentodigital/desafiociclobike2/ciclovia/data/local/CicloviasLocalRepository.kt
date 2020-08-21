package cl.talentodigital.desafiociclobike2.ciclovia.data.local

import cl.talentodigital.desafiociclobike2.ciclovia.data.local.fakeRepository.CicloviasSetup
import cl.talentodigital.desafiociclobike2.ciclovia.domain.CicloviasRepository
import cl.talentodigital.desafiociclobike2.ciclovia.domain.model.Ciclovia
import io.reactivex.Single

class CicloviasLocalRepository : CicloviasRepository {

    override fun obtenerCiclovias(): Single<List<Ciclovia>> {
        return Single.just(CicloviasSetup.init())
    }

    override fun filtrarLasCondes(): Single<List<Ciclovia>> {
        val listaFiltrada = CicloviasSetup.init().filter {
            it.comuna == "Las Condes"
        }
        return Single.just(listaFiltrada)
    }

    override fun filtrarPorTexto(texto: String): Single<List<Ciclovia>> {
        val listaFiltrada = CicloviasSetup.init().filter {
            it.comuna.contains(texto, true) || it.nombre.contains(texto, true)
        }
        return Single.just(listaFiltrada)
    }

    override fun filtrarPorNumero(numero: Int): Single<List<Ciclovia>> {
        val listaFiltrada = CicloviasSetup.init().filter {
            it.nombre.contains(numero.toString())
        }
        return Single.just(listaFiltrada)
    }
}