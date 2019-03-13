package com.ie.notes.repository;

import com.ie.notes.model.Note;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface NoteRepository extends ReactiveMongoRepository<Note, String> {

  Flux<Note> findNoteByUsername(String username);
}
