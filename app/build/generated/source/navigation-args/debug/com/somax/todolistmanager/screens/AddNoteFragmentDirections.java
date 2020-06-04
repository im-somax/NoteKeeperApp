package com.somax.todolistmanager.screens;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.somax.todolistmanager.R;

public class AddNoteFragmentDirections {
  private AddNoteFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSaveNote() {
    return new ActionOnlyNavDirections(R.id.actionSaveNote);
  }
}
