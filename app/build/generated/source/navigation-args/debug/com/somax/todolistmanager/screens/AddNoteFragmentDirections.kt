package com.somax.todolistmanager.screens

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.somax.todolistmanager.R

class AddNoteFragmentDirections private constructor() {
  companion object {
    fun actionSaveNote(): NavDirections = ActionOnlyNavDirections(R.id.actionSaveNote)
  }
}
