package chatcross.nimbl3.com.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import chat.common.nimbl3.com.repo.ApiRepository
import chat.common.nimbl3.com.callbacks.IRepositoryCallback
import chat.common.nimbl3.com.model.DataForm
import chat.common.nimbl3.com.model.QueryResponse
import chatcross.nimbl3.com.R
import chatcross.nimbl3.com.ui.base.BaseActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : BaseActivity(R.layout.activity_main), IRepositoryCallback {
    lateinit var lvRepositories: ListView
    lateinit var tvInput: EditText
    lateinit var btSubmit: Button

    lateinit var repoPresenter: ApiRepository
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Chat")
        initViews()

        if (savedInstanceState == null) {
            repoPresenter = ApiRepository(this)
            load()
        }
    }

    fun initViews() {
        tvInput = findViewById<EditText>(R.id.input_text)
        lvRepositories = findViewById<ListView>(R.id.lv_repositories)
        lvRepositories.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
        lvRepositories.setStackFromBottom(true);
        btSubmit = findViewById<Button>(R.id.submit)
        btSubmit.setOnClickListener { view -> requestMessage(tvInput.text.toString()) }
    }

    fun requestMessage(input: String) {
        val contexts: MutableList<String> = mutableListOf(input)
        repoPresenter.getMessages(AndroidSchedulers.mainThread(), Schedulers.newThread(), DataForm(contexts, input))
        append(input)
        tvInput.setText("")
    }

    fun load() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
    }

    override fun showResult(response: QueryResponse?) {
        try {
            if (response?.result?.speech.isNullOrEmpty()) return;
            append(response?.result?.speech!!)
        }catch (ex: Exception) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT)
        }
    }

    fun append(message: String) {
        adapter.add(message)
        lvRepositories.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }
}
