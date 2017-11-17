package chat.common.nimbl3.com.repo

import chat.common.nimbl3.com.service.Api
import chat.common.nimbl3.com.callbacks.IRepositoryCallback
import chat.common.nimbl3.com.model.DataForm
import chat.common.nimbl3.com.model.QueryResponse
import rx.Scheduler
import rx.Subscriber

class ApiRepository(internal var mCallback: IRepositoryCallback) {

    fun getMessages(postThread: Scheduler, subscribeThread: Scheduler, data: DataForm) {
        Api.service.queryConvos(data)
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(object : Subscriber<QueryResponse>() {
                    override fun onError(e: Throwable) {
                        mCallback.onError(e)
                    }

                    override fun onNext(queryResponse: QueryResponse) {
                        mCallback.showResult(queryResponse)
                    }

                    override fun onCompleted() {
                    }
                })
    }
}
