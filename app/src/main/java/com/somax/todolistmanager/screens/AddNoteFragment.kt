package com.somax.todolistmanager.screens

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.somax.todolistmanager.R
import com.somax.todolistmanager.database.Note

import com.somax.todolistmanager.database.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_save.setOnClickListener{view ->
            val noteTitle = editText.text.toString().trim()
            val noteBody = editText2.text.toString().trim()

            if(noteTitle.isEmpty()){
                editText.error = "Title required"
                editText2.requestFocus()
                return@setOnClickListener
            }
            launch {
                val note = Note(noteTitle, noteBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Note Saved")

                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)
                }
            }
        }
    }
}
