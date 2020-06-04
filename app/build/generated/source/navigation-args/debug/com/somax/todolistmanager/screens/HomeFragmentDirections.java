package com.somax.todolistmanager.screens;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import com.somax.todolistmanager.R;
import com.somax.todolistmanager.database.Note;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static ActionAddNote actionAddNote() {
    return new ActionAddNote();
  }

  public static class ActionAddNote implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionAddNote() {
    }

    @NonNull
    public ActionAddNote setNote(@Nullable Note Note) {
      this.arguments.put("Note", Note);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("Note")) {
        Note Note = (Note) arguments.get("Note");
        if (Parcelable.class.isAssignableFrom(Note.class) || Note == null) {
          __result.putParcelable("Note", Parcelable.class.cast(Note));
        } else if (Serializable.class.isAssignableFrom(Note.class)) {
          __result.putSerializable("Note", Serializable.class.cast(Note));
        } else {
          throw new UnsupportedOperationException(Note.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      } else {
        __result.putSerializable("Note", null);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.actionAddNote;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public Note getNote() {
      return (Note) arguments.get("Note");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAddNote that = (ActionAddNote) object;
      if (arguments.containsKey("Note") != that.arguments.containsKey("Note")) {
        return false;
      }
      if (getNote() != null ? !getNote().equals(that.getNote()) : that.getNote() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAddNote(actionId=" + getActionId() + "){"
          + "Note=" + getNote()
          + "}";
    }
  }
}
