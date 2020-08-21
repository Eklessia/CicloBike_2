package cl.talentodigital.desafiociclobike2.ciclovia.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.desafiociclobike2.ciclovia.domain.model.Ciclovia
import cl.talentodigital.desafiociclobike2.databinding.CicloviasItemBinding

class CicloviasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = CicloviasItemBinding.bind(itemView)

    fun bind(ciclovia: Ciclovia) {
        binding.apply {
            tvComuna.text = ciclovia.comuna
            tvNombreCiclovia.text = ciclovia.nombre
        }
    }
}
