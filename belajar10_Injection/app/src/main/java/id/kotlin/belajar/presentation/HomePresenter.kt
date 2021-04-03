package id.kotlin.belajar.presentation

import id.kotlin.belajar.data.HomeDatasource
import id.kotlin.belajar.data.HomeRespone
import id.kotlin.belajar.di.module.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeView) {

    fun discoverMovie() {
        view.onShowLoading()

        val datasource = NetworkModule.providesHttpAdapter()
            .create(HomeDatasource::class.java)
        datasource.discoverMovie().enqueue(object : Callback<HomeRespone> {
            override fun onResponse(call: Call<HomeRespone>, response: Response<HomeRespone>) {
                view.onHideLoading()
                view.onResponse(response.body()?.results ?: emptyList())
            }

            override fun onFailure(call: Call<HomeRespone>, t: Throwable) {
                view.onHideLoading()
                view.onFailure(t)
            }
        })
    }
}