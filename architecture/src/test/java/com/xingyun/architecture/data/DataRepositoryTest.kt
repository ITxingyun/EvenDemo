package com.xingyun.architecture.data

import com.xingyun.architecture.data.entity.Article
import com.xingyun.architecture.data.local.ILocalDataSource
import com.xingyun.architecture.data.remote.IRemoteDataSource
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class DataRepositoryTest {
    @MockK
    lateinit var remoteDataSource: IRemoteDataSource

    @MockK
    lateinit var localDataSource: ILocalDataSource

    private lateinit var dataRepository: DataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dataRepository = DataRepository(remoteDataSource, localDataSource)
    }


    @Test
    fun test_loadArticles_from_local() {
        val articleId = 123
        val article = Article(
                "title",
                "content",
                articleId
        )
        every { localDataSource.getArticle(articleId) } returns article
        dataRepository.loadArticles(articleId)
        verify(exactly = 1) { localDataSource.getArticle(articleId) }
        verify { remoteDataSource wasNot Called }
    }

    @Test
    fun test_loadArticles_from_remote() {
        val articleId = 123
        val article = Article(
                "title",
                "content",
                articleId
        )
        every { localDataSource.getArticle(articleId) } returns null
        every { remoteDataSource.getArticle(articleId) } returns article
        justRun { localDataSource.cacheArticle(article) }
        dataRepository.loadArticles(articleId)
        verifyOrder {
            localDataSource.getArticle(articleId)
            remoteDataSource.getArticle(articleId)
            localDataSource.cacheArticle(article)
        }
    }

    @Test
    fun test_loadArticles_force_from_remote() {
        val articleId = 123
        val article = Article(
                "title",
                "content",
                articleId
        )
        every { remoteDataSource.getArticle(articleId) } returns article
        justRun { localDataSource.cacheArticle(article) }
        dataRepository.loadArticles(articleId, true)
        verifyOrder {
            remoteDataSource.getArticle(articleId)
            localDataSource.cacheArticle(article)
        }
        verify(exactly = 0) { localDataSource.getArticle(articleId) }
    }

}