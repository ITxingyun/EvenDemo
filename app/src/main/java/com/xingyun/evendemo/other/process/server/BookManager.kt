package com.xingyun.evendemo.other.process.server

import android.os.IInterface

interface BookManager : IInterface {
    fun getBooks(): List<Book>

    fun addBook(book: Book)
}