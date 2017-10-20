package chatcross.nimbl3.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import chat.common.nimbl3.com.model.Repository
import chat.common.nimbl3.com.repo.RepoRepository
import chat.common.nimbl3.com.callbacks.IRepositoryCallback
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity(), IRepositoryCallback {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.tv_messages)
        if (savedInstanceState == null) {
            load()
        }
    }

    fun load() {
        val repoPresenter = RepoRepository(this)
        repoPresenter.getMessages(AndroidSchedulers.mainThread(), Schedulers.newThread())
    }

    override fun showRepositories(allRepositories: List<Repository>) {
        var messages = ""
        for (repository: Repository in allRepositories) {
            messages += repository.name + "\n"
        }
        textView.text = messages
    }

    override fun onError(error: Throwable) {
        // Handle error
    }
}
