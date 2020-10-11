package com.example.notes.data

import android.annotation.SuppressLint
import java.util.*

//Single tone
object NotesRepo {
    val notes = mutableListOf<Note>(
        Note("First label",
        "First note body",
            Calendar.getInstance().time,
            0xffd0db61.toInt()),

        Note("Second label",
            "Second label body",
            Calendar.getInstance().time,
            0xffd1e231.toInt()),

        Note("Third label",
            "Third label body",
            Calendar.getInstance().time,
            0xffd9e650.toInt())
    )
}