package abdul.com.userlogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView=findViewById(R.id.list)as RecyclerView
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val users=ArrayList<User>()
        users.add(User("abdul","kl"))
        users.add(User("Con","JB"))
        users.add(User("Ghost","PENANG"))
        users.add(User("abdul","kl2"))
        val adapter=CustomAdapter(users)
        recyclerView.adapter=adapter


    }
}
