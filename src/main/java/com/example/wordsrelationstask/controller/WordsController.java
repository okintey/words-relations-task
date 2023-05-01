package com.example.wordsrelationstask.controller;

import com.example.wordsrelationstask.model.WordsRelation;
import com.example.wordsrelationstask.service.WordsRelationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/words-relations")
@RequiredArgsConstructor
public class WordsController {

    private final WordsRelationService service;

    @PostMapping
    public ResponseEntity<WordsRelation> create(@RequestBody @Valid WordsRelation wordsRelation) {
        return ResponseEntity.ok()
                .body(service.createNewRelation(wordsRelation));
    }
}
