package chat.common.nimbl3.com.service

import chat.common.nimbl3.com.model.DataForm
import chat.common.nimbl3.com.model.QueryResponse
import chat.common.nimbl3.com.model.Repository
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import rx.Observable

interface ApiInterface {

    @POST("query")
    fun queryConvos(@Body data: DataForm): Observable<QueryResponse>
}
