package cl.talentodigital.desafiociclobike2.ciclovia.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.desafiociclobike2.ciclovia.domain.model.Ciclovia
import cl.talentodigital.desafiociclobike2.R

class CicloviasAdapter(
    private val list: List<Ciclovia>
) : RecyclerView.Adapter<CicloviasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CicloviasViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.ciclovias_item, parent, false)
        return CicloviasViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CicloviasViewHolder, position: Int) {
        holder.bind(list[position])
    }
}