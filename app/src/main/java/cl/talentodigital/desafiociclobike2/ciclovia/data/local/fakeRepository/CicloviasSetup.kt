package cl.talentodigital.desafiociclobike2.ciclovia.data.local.fakeRepository

import cl.talentodigital.desafiociclobike2.ciclovia.domain.model.Ciclovia

object CicloviasSetup {

    private val nombres = arrayOf(
        "Ciclovia 1",
        "Ciclovia 2",
        "Ciclovia 3",
        "Ciclovia 4",
        "Ciclovia 5",
        "Ciclovia 6",
        "Ciclovia 7",
        "Ciclovia 8",
        "Ciclovia 9",
        "Ciclovia 10"
    )

    private val comunas = arrayOf(
        "Las Condes",
        "La Reina",
        "Ñuñoa",
        "Macul",
        "Providencia",
        "Independencia",
        "Recoleta",
        "La Granja",
        "Maipu",
        "Quilicura"
    )

    fun init(): List<Ciclovia> {
        val lista: MutableList<Ciclovia> = ArrayList()
        for (i in 0..9) {
            val ciclovia = Ciclovia(nombres[i], comunas[i])
            lista.add(ciclovia)
        }
        return lista
    }
}