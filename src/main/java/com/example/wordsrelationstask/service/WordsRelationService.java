package com.example.wordsrelationstask.service;

import com.example.wordsrelationstask.entity.WordsRelationEntity;
import com.example.wordsrelationstask.model.WordsRelation;
import com.example.wordsrelationstask.repository.WordsRelationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordsRelationService {

    private final WordsRelationRepository repository;
    private final ModelMapper modelMapper;

    public WordsRelation createNewRelation(WordsRelation wordsRelation) {
        WordsRelationEntity savedEntity = repository.save(modelMapper.map(wordsRelation, WordsRelationEntity.class));
        return modelMapper.map(savedEntity, WordsRelation.class);
    }
}
