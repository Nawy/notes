package com.ie.notes.service;

import com.ie.notes.model.Note;
import com.ie.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NoteService {

  private final NoteRepository noteRepository;

  public Flux<Note> getByUsername(String username) {
    return noteRepository.findNoteByUsername(username);
  }

  public Mono<Note> get(String noteId) {
    return noteRepository.findById(noteId);
  }

  public Mono<Note> save(Note note) {
    return noteRepository.save(note);
  }
}
