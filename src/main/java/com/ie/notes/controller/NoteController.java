package com.ie.notes.controller;

import com.ie.notes.model.Note;
import com.ie.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController implements AuthController {

  private final NoteService noteService;

  @GetMapping("/users/{username}/notes/{noteId}")
  public Mono<Note> get(
      @PathVariable("username") String username,
      @PathVariable("noteId") String noteId
  ) {
    return auth(username).flatMap(details -> noteService.get(noteId));
  }

  @GetMapping("/users/{username}/notes")
  public Flux<Note> getByUserId(@PathVariable("username") String username) {
    return auth(username).flatMapMany(details -> noteService.getByUsername(details.getUsername()));
  }

  @PostMapping("/users/{username}/notes")
  public Mono<Note> save(@RequestBody Note note) {
    return noteService.save(note);
  }
}
