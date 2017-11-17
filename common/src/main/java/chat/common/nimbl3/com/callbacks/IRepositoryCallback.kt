package chat.common.nimbl3.com.callbacks

import chat.common.nimbl3.com.model.QueryResponse
import chat.common.nimbl3.com.model.Repository

/**
 * Created by trung on 10/19/17.
 */

interface IRepositoryCallback {
    fun showResult(response: QueryResponse?)
    fun onError(error: Throwable)
}
