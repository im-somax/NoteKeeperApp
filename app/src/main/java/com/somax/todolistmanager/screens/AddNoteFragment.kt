package com.somax.todolistmanager.screens

import android.app.AlertDialog
import android.os.AsyncTask
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.somax.todolistmanager.R
import com.somax.todolistmanager.database.Note

import com.somax.todolistmanager.database.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment() {

    private var note: Note? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        arguments?.let{
            note = AddNoteFragmentArgs.fromBundle(it).note
            editText.setText(note?.title)
            editText2.setText(note?.note)
        }

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
                    val mNote = Note(noteTitle, noteBody)

                    if(note == null) {
                        NoteDatabase(it).getNoteDao().addNote(mNote)
                        it.toast("Note Saved")
                    }
                    else{
                        mNote.id = note!!.id
                        NoteDatabase(it).getNoteDao().updateNote(mNote)
                        it.toast("Note Updated")
                    }
                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)
                }
            }
        }
    }

    private fun deleteNote(){
        AlertDialog.Builder(context).apply {
            setTitle("Are you sure?")
            setMessage("You connot undo this opertion")
            setPositiveButton("Yes"){ _, _ ->
                launch {
                    NoteDatabase(context).getNoteDao().deleteNote(note!!)
                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view!!).navigate(action)
                }
            }
            setNegativeButton("No"){ _, _ ->
            }
        }.create().show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete -> if (note != null) deleteNote() else context?.toast("Cannot Delete note")
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
}
