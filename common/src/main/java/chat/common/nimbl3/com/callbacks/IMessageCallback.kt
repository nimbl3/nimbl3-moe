package chat.common.nimbl3.com.callbacks

import chat.common.nimbl3.com.model.Message

/**
 * Created by trung on 10/19/17.
 */

interface IMessageCallback {
    fun showMessages(message: List<Message>)
}
