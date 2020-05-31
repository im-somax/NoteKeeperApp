package com.somax.todolistmanager.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.somax.todolistmanager.R
import com.somax.todolistmanager.database.Note
import kotlinx.android.synthetic.main.notes_layout.view.*

class NotesAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>(){

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.notes_layout, parent, false)
        )
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
           holder.view.text_view_title.text = notes[position].title
           holder.view.text_view_note.text = notes[position].note
    }

}