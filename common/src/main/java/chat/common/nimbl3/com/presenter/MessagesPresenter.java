package chat.common.nimbl3.com.presenter;

import java.util.List;

import chat.common.nimbl3.com.model.Message;
import chat.common.nimbl3.com.service.Api;
import chat.common.nimbl3.com.service.GithubApi;
import chat.common.nimbl3.com.view.IMessageView;
import rx.Scheduler;
import rx.Subscriber;

public class MessagesPresenter {

    IMessageView mView;

    public MessagesPresenter(IMessageView view) {
        this.mView = view;
    }

    public void getMessages(Scheduler postThread, Scheduler subscribeThread) {
        GithubApi gitHubApi = Api.createService(GithubApi.class);
        gitHubApi.getRepos()
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(new Subscriber<List<Message>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Message> repositories) {
                        mView.showMessages(repositories);
                    }
                });
    }
}
