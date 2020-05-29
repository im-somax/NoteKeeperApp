package com.somax.todolistmanager.screens

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.somax.todolistmanager.R

class HomeFragmentDirections private constructor() {
  companion object {
    fun actionAddNote(): NavDirections = ActionOnlyNavDirections(R.id.actionAddNote)
  }
}
