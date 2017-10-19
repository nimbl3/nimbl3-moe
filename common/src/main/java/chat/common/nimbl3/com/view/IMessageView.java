package chat.common.nimbl3.com.view;

import java.util.List;

import chat.common.nimbl3.com.model.Message;

/**
 * Created by trung on 10/19/17.
 */

public interface IMessageView {
    void showMessages(List<Message> message);
}
