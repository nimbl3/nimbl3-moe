package chat.nimbl3.presenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import apple.foundation.NSOperationQueue;
import apple.uikit.UITableView;
import chat.common.nimbl3.com.callbacks.IRepositoryCallback;
import chat.common.nimbl3.com.model.Repository;
import chat.common.nimbl3.com.repo.ApiRepository;
import chat.nimbl3.schedulers.IOSSchedulers;
import chat.nimbl3.view.BaseView;

/**
 * Created by trung on 10/20/17.
 */

public class RepositoryPresenter implements IRepositoryCallback {
    private List<Repository> mAllRepositories = new ArrayList<>();

    BaseView mView;
    UITableView mViewComponent;

    public RepositoryPresenter(BaseView baseView, UITableView component, NSOperationQueue operationQueue) {
        this.mView = baseView;
        this.mViewComponent = component;
        ApiRepository repository = new ApiRepository(this);
        repository.getMessages(IOSSchedulers.mainThread(), IOSSchedulers.handlerThread(operationQueue));
    }


    public List<Repository> getListMessagess() {
        return this.mAllRepositories;
    }

    @Override
    public void showResult(@NotNull List<Repository> allRepositories) {
        this.mAllRepositories = allRepositories;
        mViewComponent.reloadData();
    }

    @Override
    public void onError(@NotNull Throwable error) {
        // Handle error
    }
}
