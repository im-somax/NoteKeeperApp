package com.somax.todolistmanager.screens

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.somax.todolistmanager.database.Note
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class AddNoteFragmentArgs(
  val Note: Note? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Note::class.java)) {
      result.putParcelable("Note", this.Note as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Note::class.java)) {
      result.putSerializable("Note", this.Note as Serializable?)
    }
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): AddNoteFragmentArgs {
      bundle.setClassLoader(AddNoteFragmentArgs::class.java.classLoader)
      val __Note : Note?
      if (bundle.containsKey("Note")) {
        if (Parcelable::class.java.isAssignableFrom(Note::class.java) ||
            Serializable::class.java.isAssignableFrom(Note::class.java)) {
          __Note = bundle.get("Note") as Note?
        } else {
          throw UnsupportedOperationException(Note::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __Note = null
      }
      return AddNoteFragmentArgs(__Note)
    }
  }
}
