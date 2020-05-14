package com.xingyun.evendemo.other.process.server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException
import android.util.Log

class RemoteService: Service() {

    private var books = mutableListOf<Book>()


    override fun onCreate() {
        super.onCreate()
        val book = Book("三体")
        books.add(book)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return bookManager
    }

    private val bookManager: Stub =
        object : Stub() {
            @Throws(RemoteException::class)
            override fun getBooks(): List<Book> {
                synchronized(this) {
                    return books
                }
            }

            @Throws(RemoteException::class)
            override fun addBook(book: Book) {
                synchronized(this) {
                    books.add(book)
                    Log.e("Server", "新添: ${book.bookName}")
                }
            }
        }

}