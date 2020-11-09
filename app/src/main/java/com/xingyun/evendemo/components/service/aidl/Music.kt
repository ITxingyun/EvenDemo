package com.xingyun.evendemo.components.service.aidl

import android.os.Parcel
import android.os.Parcelable

class Music(var musicName: String?, var quality: String?) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.run {
            writeString(musicName)
            writeString(quality)
        }
    }

    override fun describeContents(): Int = 0

    override fun toString(): String {
        return "{musicName: $musicName, quality: $quality}"
    }

    companion object CREATOR : Parcelable.Creator<Music> {
        override fun createFromParcel(parcel: Parcel): Music {
            return Music(parcel)
        }

        override fun newArray(size: Int): Array<Music?> {
            return arrayOfNulls(size)
        }
    }

}