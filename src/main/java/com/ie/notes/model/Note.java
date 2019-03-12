package com.ie.notes.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Note {
  private UUID id;
  private UUID userId;
  private String title;
  private List<NoteItem> items;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
}
