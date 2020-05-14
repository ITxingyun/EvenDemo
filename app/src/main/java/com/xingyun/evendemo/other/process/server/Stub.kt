package com.xingyun.evendemo.other.process.server

import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import com.xingyun.evendemo.other.process.proxy.Proxy
import com.xingyun.evendemo.other.process.server.Book.CREATOR.createFromParcel

abstract class Stub: Binder(), BookManager {

    override fun addBook(book: Book) {
        TODO("Not yet implemented")
    }

    override fun asBinder(): IBinder {
        return this
    }

    override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
        when(code) {
            INTERFACE_TRANSACTION -> {
                reply?.writeString(DESCRIPTOR)
                return true
            }

            TRANSAVTION_addBook -> {
                data.enforceInterface(DESCRIPTOR)
                var arg0: Book? = null
                if (data.readInt() !== 0) {
                    arg0 = createFromParcel(data)
                }
                addBook(arg0!!)
                reply!!.writeNoException()
                return true
            }

            TRANSAVTION_getBooks -> {
                data.enforceInterface(DESCRIPTOR)
                val result: List<Book> = this.getBooks()
                reply?.writeNoException()
                reply?.writeTypedList(result)
                return true
            }
        }


        return super.onTransact(code, data, reply, flags)
    }


    companion object {
        const val DESCRIPTOR = "com.xingyun.evendemo.other.process.server.BookManager"
        const val TRANSAVTION_getBooks = IBinder.FIRST_CALL_TRANSACTION
        const val TRANSAVTION_addBook = IBinder.FIRST_CALL_TRANSACTION + 1

        fun asInterface(binder: IBinder): BookManager? {
            val iin = binder.queryLocalInterface(DESCRIPTOR)
            return if (iin != null && iin is BookManager) iin else Proxy(binder)
        }
    }

}