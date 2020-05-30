package com.somax.todolistmanager.screens

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.somax.todolistmanager.R
import com.somax.todolistmanager.database.Note

import com.somax.todolistmanager.database.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*

class AddNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_save.setOnClickListener{
            val noteTitle = editText.text.toString().trim()
            val noteBody = editText2.text.toString().trim()

            if(noteTitle.isEmpty()){
                editText.error = "Title required"
                editText2.requestFocus()
                return@setOnClickListener
            }
            val note = Note(noteTitle, noteBody)

            saveNote(note)
        }
    }

    private fun saveNote(note : Note){
        class SaveNote : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg params: Void?): Void? {
                NoteDatabase(activity!!).getNoteDao().addNote(note)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)

                Toast.makeText(activity, "Note Saved", Toast.LENGTH_LONG).show()
            }
        }
        SaveNote().execute()
    }
}
