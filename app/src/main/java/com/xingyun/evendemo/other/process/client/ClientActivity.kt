package com.xingyun.evendemo.other.process.client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ActivityClientBinding
import com.xingyun.evendemo.other.process.server.Book
import com.xingyun.evendemo.other.process.server.BookManager
import com.xingyun.evendemo.other.process.server.RemoteService
import com.xingyun.evendemo.other.process.server.Stub

class ClientActivity: AppCompatActivity() {

    private var bookManager: BookManager? = null
    private var isConnection = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityClientBinding>(this, R.layout.activity_client)

        binding.btnAddBook.setOnClickListener {
            if (!isConnection) {
                attemptToBindService()
                return@setOnClickListener
            }
            if (bookManager == null) return@setOnClickListener
            try {
                val book = Book("赘婿")
                bookManager?.addBook(book)
                val books: List<Book> = bookManager!!.getBooks()
                val string = StringBuilder()
                books.forEach { string.append(it.bookName + " ") }
                Log.e("ClientActivity", "books = $string")
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }

    private fun attemptToBindService() {
        val intent = Intent(this, RemoteService::class.java)
        intent.action = "com.xingyun.evendemo.ipc.server"
        bindService(intent, bookServiceConnection, Context.BIND_AUTO_CREATE)
    }

    private val bookServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            isConnection = true
            bookManager = Stub.asInterface(service)
            if (bookManager != null) {
                try {
                    val books: List<Book> = bookManager!!.getBooks()
                    val string = StringBuilder()
                    books.forEach { string.append(it.bookName+ " ") }
                    Log.e("ClientActivity", "books = $string")
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isConnection = false
        }
    }

    override fun onStart() {
        super.onStart()
        if (!isConnection) {
            attemptToBindService()
        }
    }

    override fun onStop() {
        super.onStop()
        if (isConnection) {
            unbindService(bookServiceConnection)
        }
    }
}