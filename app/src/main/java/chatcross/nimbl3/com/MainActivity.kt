package chatcross.nimbl3.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import chat.common.nimbl3.com.model.Message
import chat.common.nimbl3.com.presenter.MessagesPresenter
import chat.common.nimbl3.com.view.IMessageView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MainActivity : AppCompatActivity(), IMessageView {

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
        val repoPresenter = MessagesPresenter(this)
        repoPresenter.getMessages(AndroidSchedulers.mainThread(), Schedulers.newThread())
    }

    override fun showMessages(allRepositories: MutableList<Message>) {
        var messages = ""
        for (message: Message in allRepositories) {
            messages += message.name + "\n"
        }
        textView.text = messages
    }

}
