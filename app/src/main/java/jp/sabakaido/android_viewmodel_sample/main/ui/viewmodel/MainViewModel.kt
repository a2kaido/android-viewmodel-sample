package jp.sabakaido.android_viewmodel_sample.main.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import jp.sabakaido.android_viewmodel_sample.main.model.GithubRepos
import jp.sabakaido.android_viewmodel_sample.main.service.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by anikaido on 2017/06/20.
 */
class MainViewModel : ViewModel() {
    private val githubRepos = MutableLiveData<List<GithubRepos>>()

    fun getGithubRepos(): LiveData<List<GithubRepos>>? {
        return githubRepos
    }

    fun fetchGithubRespos(userName: String) {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val call = retrofit.create(GithubService::class.java).listGitHubRepos(userName)

        call.enqueue(object : Callback<List<GithubRepos>> {
            override fun onFailure(call: Call<List<GithubRepos>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<GithubRepos>>?, response: Response<List<GithubRepos>>?) {
                response.let {
                    githubRepos?.value = response?.body()
                }
            }
        })
    }
}