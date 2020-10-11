package com.example.notes.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.data.Note
import kotlinx.android.synthetic.main.note_preview_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Adapter to display notes
 */
class NotesRVAdapter : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note_preview_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) = with(itemView) {
            note_title.text = note.title
            note_date.text = SimpleDateFormat(context.getString(R.string.date_format), Locale.getDefault()).format(note.date)
            note_body.text = note.text
            setBackgroundColor(note.color)
        }
    }
}