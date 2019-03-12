package com.ie.notes.repository;

import com.ie.notes.model.Note;
import java.util.UUID;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface NoteRepository extends ReactiveMongoRepository<Note, UUID> {

  Flux<Note> findNoteByUserId(UUID userId);
}
