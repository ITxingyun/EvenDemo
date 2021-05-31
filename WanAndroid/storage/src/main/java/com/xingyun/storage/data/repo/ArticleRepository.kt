package com.xingyun.storage.data.repo

import com.xingyun.storage.data.local.ILocalArticleDataSource
import com.xingyun.storage.data.remote.IRemoteArticleDataSource
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val remoteArticleDataSource: IRemoteArticleDataSource,
    private val localArticleDataSource: ILocalArticleDataSource
) {

}