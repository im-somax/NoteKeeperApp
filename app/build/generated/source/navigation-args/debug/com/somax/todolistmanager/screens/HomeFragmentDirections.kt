package com.somax.todolistmanager.screens

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.somax.todolistmanager.R
import com.somax.todolistmanager.database.Note
import java.io.Serializable
import kotlin.Int
import kotlin.Suppress

class HomeFragmentDirections private constructor() {
  private data class ActionAddNote(
    val Note: Note? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.actionAddNote

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Note::class.java)) {
        result.putParcelable("Note", this.Note as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(Note::class.java)) {
        result.putSerializable("Note", this.Note as Serializable?)
      }
      return result
    }
  }

  companion object {
    fun actionAddNote(Note: Note? = null): NavDirections = ActionAddNote(Note)
  }
}
