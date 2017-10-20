package chatcross.nimbl3.com.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import chatcross.nimbl3.com.R
import chatcross.nimbl3.com.ui.base.BaseActivity

class ChatActivity : BaseActivity(R.layout.activity_chat) {
    companion object {
        fun show(from: Activity) {
            var intent = Intent(from, ChatActivity::class.java)
            ContextCompat.startActivity(from, intent, null)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Chat")
    }
}
