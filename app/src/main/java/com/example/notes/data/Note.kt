package com.example.notes.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Note (val id : String,
                 val title : String,
                 val text : String,
                 val lastChanged : Date,
                 val color : PredefinedColor
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (id != other.id) return false
        return true
    }

    enum class PredefinedColor {
        WHITE,
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        DARK_BLUE,
        VIOLET
    }
}

