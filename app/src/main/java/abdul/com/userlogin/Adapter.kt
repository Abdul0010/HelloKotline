package abdul.com.userlogin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class CustomAdapter(val userList:ArrayList<User>):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v=LayoutInflater.from(p0?.context).inflate(R.layout.card,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        val user:User= userList[p1]
        p0?.Name.text=user.name;
        p0?.Address.text=user.address
    }

    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val Name=itemView.findViewById(R.id.name)as TextView
        val Address=itemView.findViewById(R.id.address)as TextView


    }

}