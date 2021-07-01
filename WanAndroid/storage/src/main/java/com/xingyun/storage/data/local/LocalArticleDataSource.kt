package com.xingyun.storage.data.local

import com.xingyun.storage.data.db.AppDatabase
import javax.inject.Inject

class LocalArticleDataSource @Inject constructor(private val appDatabase: AppDatabase) : ILocalArticleDataSource {


}