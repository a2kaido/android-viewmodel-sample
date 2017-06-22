package jp.sabakaido.android_viewmodel_sample.main.service

import jp.sabakaido.android_viewmodel_sample.main.model.GithubRepos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by anikaido on 2017/06/21.
 */
interface GithubService {
    @GET("users/{user}/repos")
    fun listGitHubRepos(@Path("user") user: String): Call<List<GithubRepos>>
}