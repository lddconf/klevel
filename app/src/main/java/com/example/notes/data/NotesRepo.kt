package com.example.notes.data

import android.annotation.SuppressLint
import java.util.*

//Single tone
object NotesRepo {
    val notes = mutableListOf<Note>(
        Note( UUID.randomUUID().toString(),
            "First label555555555555555555555555555555555555555555555555555555555555555",
            "First note body",
            Calendar.getInstance().time,
            Note.PredefinedColor.GREEN),

        Note(UUID.randomUUID().toString(),
            "Second label",
            "Second label body",
            Calendar.getInstance().time,
            Note.PredefinedColor.ORANGE),

        Note(UUID.randomUUID().toString(),
            "Third label",
            "Third label body 566666666666666666666666666666666666666666666666666666666666",
            Calendar.getInstance().time,
            Note.PredefinedColor.VIOLET)
    )
}