package com.example.wordsrelationstask.controller;

import com.example.wordsrelationstask.model.RelationsEnum;
import com.example.wordsrelationstask.model.WordsRelation;
import com.example.wordsrelationstask.model.WordsRelationWithInverse;
import com.example.wordsrelationstask.service.WordsRelationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<WordsRelationWithInverse>> getAll(@RequestParam(required = false) RelationsEnum relation,
                                                                 @RequestParam(defaultValue = "false") boolean showInverse) {
        return ResponseEntity.ok()
                .body(service.getAllRelations(relation, showInverse));
    }
}
