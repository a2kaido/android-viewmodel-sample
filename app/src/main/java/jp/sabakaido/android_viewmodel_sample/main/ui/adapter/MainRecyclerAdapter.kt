package jp.sabakaido.android_viewmodel_sample.main.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import jp.sabakaido.android_viewmodel_sample.R
import jp.sabakaido.android_viewmodel_sample.main.model.GithubRepos

/**
 * Created by anikaido on 2017/06/21.
 */
class MainRecyclerAdapter(context: Context, val data: List<GithubRepos>?) : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    private val inflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        data ?: return

        if (data.size <= position) return

        holder?.nameView?.text = data[position].name
        holder?.langView?.text = data[position].language
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_main, parent, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameView = itemView.findViewById<TextView>(R.id.name)
        val langView = itemView.findViewById<TextView>(R.id.lang)
    }
}