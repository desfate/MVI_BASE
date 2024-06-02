package com.live.allo.business.models

import android.os.Parcel
import android.os.Parcelable

data class TestData(
    var id: Int,
    var name: String?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestData> {
        override fun createFromParcel(parcel: Parcel): TestData {
            return TestData(parcel)
        }

        override fun newArray(size: Int): Array<TestData?> {
            return arrayOfNulls(size)
        }
    }

}
