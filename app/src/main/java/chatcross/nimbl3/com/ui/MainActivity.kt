package chatcross.nimbl3.com.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import chat.common.nimbl3.com.model.Repository
import chat.common.nimbl3.com.repo.RepoRepository
import chat.common.nimbl3.com.callbacks.IRepositoryCallback
import chatcross.nimbl3.com.R
import chatcross.nimbl3.com.ui.ChatActivity
import chatcross.nimbl3.com.ui.base.BaseActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : BaseActivity(R.layout.activity_main), IRepositoryCallback {
    lateinit var lvRepositories: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Repositories")
        initViews()
        if (savedInstanceState == null) {
            load()
        }
    }

    fun initViews() {
        lvRepositories = findViewById<ListView>(R.id.lv_repositories)

        enableActionBarRightButton("Next", View.OnClickListener { v -> ChatActivity.show(this) })
    }

    fun load() {
        val repoPresenter = RepoRepository(this)
        repoPresenter.getMessages(AndroidSchedulers.mainThread(), Schedulers.newThread())
    }

    override fun showRepositories(allRepositories: List<Repository>) {
        var adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        for (repository: Repository in allRepositories) {
            adapter.add(repository.name)
        }
        lvRepositories.adapter = adapter
        lvRepositories.deferNotifyDataSetChanged()
    }

    override fun onError(error: Throwable) {
        // Handle error
    }
}
