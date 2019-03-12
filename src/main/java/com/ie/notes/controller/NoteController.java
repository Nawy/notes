package com.ie.notes.controller;

import com.ie.notes.model.Note;
import com.ie.notes.service.NoteService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

  private final NoteService noteService;

  @GetMapping("/{noteId}")
  public Mono<Note> get(@PathVariable("noteId") UUID noteId) {
    return noteService.get(noteId);
  }

  @GetMapping("/")
  public Flux<Note> getByUserId(@RequestParam("userId") UUID userId) {
    return noteService.getByUserId(userId);
  }

  @PostMapping
  public Mono<Note> save(@RequestBody Note note) {
    return noteService.save(note);
  }
}
