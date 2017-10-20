package chat.common.nimbl3.com.callbacks

import chat.common.nimbl3.com.model.Repository

/**
 * Created by trung on 10/19/17.
 */

interface IRepositoryCallback {
    fun showRepositories(repository: List<Repository>)
    fun onError(error: Throwable)
}
