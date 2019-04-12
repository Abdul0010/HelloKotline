package abdul.com.userlogin

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface GithubApiService {
    @GET("prices?key=aae0e39a3e3e4144cf040e5e0b514fb7")
    fun getData():Observable<List<Crypto>>



}