package com.xingyun.evendemo.other.process.server

import android.os.Parcel
import android.os.Parcelable

class Book(var bookName: String?): Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(bookName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

}