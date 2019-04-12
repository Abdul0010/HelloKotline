package abdul.com.userlogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),CustomAdapter.Listener {


    private var adapter:CustomAdapter?=null;
    private var myCompositeDisposable: CompositeDisposable?=null
    private var listData:ArrayList<Crypto>?=null
    private val url= "https://api.nomics.com/v1/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val recyclerView=findViewById(R.id.list)as RecyclerView
//        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)


        myCompositeDisposable= CompositeDisposable()
        initRecyclerView()
        getData()



    }

    private fun getData() {
        val dataInterface=Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(GithubApiService::class.java)
        myCompositeDisposable?.add(dataInterface.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse))
    }
    private fun handleResponse(cryptolist:List<Crypto>){
        listData= ArrayList(cryptolist)
        adapter=CustomAdapter(listData!!,this)
        list.adapter=adapter;

    }

    private fun initRecyclerView() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        list.layoutManager = layoutManager

    }
    override fun onItemClick(datalist: Crypto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
