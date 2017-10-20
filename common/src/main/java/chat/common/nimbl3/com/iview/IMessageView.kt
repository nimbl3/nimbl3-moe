package chat.common.nimbl3.com.iview

import chat.common.nimbl3.com.model.Message

/**
 * Created by trung on 10/19/17.
 */

interface IMessageView {
    fun showMessages(message: List<Message>)
}
