package chatcross.nimbl3.com.ui.base

import android.os.Bundle
import android.support.annotation.IntegerRes
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import chatcross.nimbl3.com.R

/**
 * Created by trung on 10/20/17.
 */

open class BaseActivity(var resLayoutId: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar!!.setCustomView(R.layout.custom_action_bar)
        setContentView(resLayoutId)
    }

    fun setTitle(titleText: String) {
        var title = supportActionBar!!.customView.findViewById<TextView>(R.id.actionbar_tv_title)
        title.text = titleText
    }

    fun enableActionBarRightButton(btText: String, onClick: View.OnClickListener) {
        var actionbarRightButton = findViewById<TextView>(R.id.actionbar_bt_right)
        actionbarRightButton.visibility = View.VISIBLE
        actionbarRightButton.text = btText
        actionbarRightButton.setOnClickListener(onClick)
    }

}
