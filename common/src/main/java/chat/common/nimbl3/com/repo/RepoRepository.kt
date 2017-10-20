package chat.common.nimbl3.com.repo

import chat.common.nimbl3.com.model.Repository
import chat.common.nimbl3.com.service.Api
import chat.common.nimbl3.com.callbacks.IRepositoryCallback
import rx.Scheduler
import rx.Subscriber

class RepoRepository(internal var mCallback: IRepositoryCallback) {

    fun getMessages(postThread: Scheduler, subscribeThread: Scheduler) {
        Api.service.repos
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(object : Subscriber<List<Repository>>() {
                    override fun onCompleted() {}

                    override fun onError(e: Throwable) {
                        mCallback.onError(e)
                    }

                    override fun onNext(repositories: List<Repository>) {
                        mCallback.showRepositories(repositories)
                    }
                })
    }
}
