package chat.common.nimbl3.com.presenter

import chat.common.nimbl3.com.model.Message
import chat.common.nimbl3.com.service.Api
import chat.common.nimbl3.com.iview.IMessageView
import rx.Scheduler
import rx.Subscriber

class MessagesPresenter(internal var mView: IMessageView) {

    fun getMessages(postThread: Scheduler, subscribeThread: Scheduler) {
        Api.service.repos
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(object : Subscriber<List<Message>>() {
                    override fun onCompleted() {}

                    override fun onError(e: Throwable) {}

                    override fun onNext(repositories: List<Message>) {
                        mView.showMessages(repositories)
                    }
                })
    }
}
