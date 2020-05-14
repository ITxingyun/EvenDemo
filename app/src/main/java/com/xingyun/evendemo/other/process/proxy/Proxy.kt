package com.xingyun.evendemo.other.process.proxy

import android.os.IBinder
import android.os.Parcel
import com.xingyun.evendemo.other.process.server.Book
import com.xingyun.evendemo.other.process.server.BookManager
import com.xingyun.evendemo.other.process.server.Stub
import com.xingyun.evendemo.other.process.server.Stub.Companion.DESCRIPTOR


class Proxy(private val remote: IBinder) : BookManager {

    override fun getBooks(): List<Book> {
        val data = Parcel.obtain()
        val replay = Parcel.obtain()
        val result: List<Book>?

        result = try {
            data.writeInterfaceToken(DESCRIPTOR)
            remote.transact(Stub.TRANSAVTION_getBooks, data, replay, 0)
            replay.readException()
            replay.createTypedArrayList(Book)
        } finally {
            replay.recycle()
            data.recycle()
        }
        return result!!
    }

    override fun addBook(book: Book) {
        val data = Parcel.obtain()
        val replay = Parcel.obtain()

        try {
            data.writeInterfaceToken(DESCRIPTOR)
            data.writeInt(1)
            book.writeToParcel(data, 0)
            remote.transact(Stub.TRANSAVTION_addBook, data, replay, 0)
            replay.readException()
        } finally {
            replay.recycle()
            data.recycle()
        }
    }

    override fun asBinder(): IBinder = remote
}