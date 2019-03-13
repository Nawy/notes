package com.ie.notes.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "notes")
@NoArgsConstructor
@AllArgsConstructor
public class Note {

  @Id
  private String id;
  private String username;
  private String title;
  private List<NoteItem> items;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
}
