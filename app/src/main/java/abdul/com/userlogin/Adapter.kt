package abdul.com.userlogin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.card.view.*
import java.text.FieldPosition


class CustomAdapter(private val datalist:ArrayList<Crypto>,private val listener:Listener):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    interface Listener {
        fun onItemClick(datalist : Crypto)
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.card,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(datalist[p1],listener ,p1)
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        fun bind(datalist: Crypto,listener:Listener,position: Int){
            itemView.setOnClickListener{listener.onItemClick(datalist)}
            itemView.name.text=datalist.currency
            itemView.address.text=datalist.price
        }

    }
}
