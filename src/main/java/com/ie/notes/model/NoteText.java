package com.ie.notes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteText implements NoteItem {
  private String text;

  @Override
  public NoteType getType() {
    return NoteType.TEXT;
  }
}
