package id.kotlin.belajar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val progressBar = findViewById<ProgressBar>(R.id.pb_home)

        val datasource = NetworkProvider.providesHttpAdapter().create(HomeDatasource::class.java)
        datasource.discoverMovie().enqueue(object : Callback<HomeRespone> {
            override fun onResponse(call: Call<HomeRespone>, respone: Response<HomeRespone>) {
                progressBar.visibility = View.GONE

                val results = respone.body()?.result
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_home)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = HomeAdapter(results ?: emptyList())
            }

            override fun onFailure(call: Call<HomeRespone>, t:Throwable) {
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")
            }
        })
    }
}

private fun <T> Call<T>.enqueue(any: Any) {

}
