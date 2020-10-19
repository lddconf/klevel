package com.example.notes.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.notes.R
import com.example.notes.data.Note
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.activity_note.view.*
import kotlinx.android.synthetic.main.note_preview_layout.*
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity : AppCompatActivity() {
    companion object {
        private val EXTRA_NOTE = "Note"
        fun startNoteActivity(context: Context, note : Note? = null ) = Intent(context,
        NoteActivity::class.java).apply {
            putExtra(EXTRA_NOTE, note)
            context.startActivity(this)
        }
    }

    private var note : Note? = null

    private val onDataChangedListener = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) = saveNote()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        setupActionBar()
        note = intent.getParcelableExtra(EXTRA_NOTE)
        initNote()

        titleEditor.editText?.addTextChangedListener(onDataChangedListener)
        noteBodyEditor.editText?.addTextChangedListener(onDataChangedListener)

    }

    private fun setupActionBar() {
        setSupportActionBar(noteToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initNote() {
        note?.let {nt ->
            note_title.text = nt.title
            note_body.text = nt.text

            val color = when(nt.color) {
                Note.PredefinedColor.WHITE ->R.color.white
                Note.PredefinedColor.RED ->R.color.red
                Note.PredefinedColor.ORANGE->R.color.orange
                Note.PredefinedColor.YELLOW->R.color.yellow
                Note.PredefinedColor.GREEN->R.color.green
                Note.PredefinedColor.BLUE->R.color.blue
                Note.PredefinedColor.DARK_BLUE->R.color.dark_blue
                Note.PredefinedColor.VIOLET->R.color.violet
            }

            noteToolbar.setBackgroundColor(ResourcesCompat.getColor(resources, color, null))
            supportActionBar?.title  = SimpleDateFormat(getString(R.string.date_format),
                Locale.getDefault()).format(nt.lastChanged)
        } ?: let {
            noteToolbar.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.white, null))
            supportActionBar?.title  = getString(R.string.new_note)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun saveNote() {
        note = note?.copy(
            title = titleEditor.editText?.text?.trim().toString(),
            text = noteBodyEditor.editText?.text.toString(),
            lastChanged = Calendar.getInstance().time
        ) ?: Note(UUID.randomUUID().toString(),
            titleEditor.editText?.text.toString(),
            noteBodyEditor.editText?.text.toString(),
            Calendar.getInstance().time, Note.PredefinedColor.WHITE )
    }
}