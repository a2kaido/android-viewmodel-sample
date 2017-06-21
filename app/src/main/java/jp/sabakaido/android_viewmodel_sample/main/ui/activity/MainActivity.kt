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
    lateinit private var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        bind()
    }

    fun bind() {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
                .getGithubRepos()
                ?.observe(this, Observer {
                    adapter = MainRecyclerAdapter(this, it)
                    recyclerView.adapter = adapter
                })
    }
}
