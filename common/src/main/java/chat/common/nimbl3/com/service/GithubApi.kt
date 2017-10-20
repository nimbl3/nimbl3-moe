package chat.common.nimbl3.com.service

import chat.common.nimbl3.com.model.Repository
import retrofit2.http.GET
import rx.Observable

interface GithubApi {
    @get:GET("orgs/nimbl3/repos")
    val repos: Observable<List<Repository>>
}
