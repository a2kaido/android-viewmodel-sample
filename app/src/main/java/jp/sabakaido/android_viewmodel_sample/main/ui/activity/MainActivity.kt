package jp.sabakaido.android_viewmodel_sample.main.ui.activity

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import jp.sabakaido.android_viewmodel_sample.R
import jp.sabakaido.android_viewmodel_sample.main.ui.adapter.MainRecyclerAdapter
import jp.sabakaido.android_viewmodel_sample.main.ui.viewmodel.MainViewModel

class MainActivity : LifecycleActivity() {
    private var adapter: MainRecyclerAdapter? = null
    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        observeViewModelAndFetchData()
    }

    private fun observeViewModelAndFetchData() {
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel
                .getGithubRepos()
                .observe(this, Observer {
                    adapter = MainRecyclerAdapter(this, it)
                    recyclerView.adapter = adapter
                })

        viewModel.fetchGithubRespos("a2kaido")
    }
}
