package com.example.wordsrelationstask.service;

import com.example.wordsrelationstask.entity.WordsRelationEntity;
import com.example.wordsrelationstask.model.WordsRelationWithInverse;
import com.example.wordsrelationstask.model.RelationsEnum;
import com.example.wordsrelationstask.model.WordsRelation;
import com.example.wordsrelationstask.repository.WordsRelationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordsRelationService {

    private final WordsRelationRepository repository;
    private final ModelMapper modelMapper;

    public WordsRelation createNewRelation(WordsRelation wordsRelation) {
        WordsRelationEntity savedEntity = repository.save(modelMapper.map(wordsRelation, WordsRelationEntity.class));
        return modelMapper.map(savedEntity, WordsRelation.class);
    }

    public List<WordsRelationWithInverse> getAllRelations(RelationsEnum relation, boolean showInverse) {
        List<WordsRelationEntity> entities = relation != null ? repository.findAllByRelation(relation.name()) :
                repository.findAll();
        List<WordsRelationWithInverse> wordsRelations = new java.util.ArrayList<>(entities.stream()
                .map(e -> modelMapper.map(e, WordsRelationWithInverse.class)).toList());
        if (showInverse) {
            wordsRelations.addAll(getInverseRelations(wordsRelations));
        }
        return wordsRelations;
    }

    private List<WordsRelationWithInverse> getInverseRelations(List<WordsRelationWithInverse> relations) {
        return relations.stream().map(this::createInverseWordsRelations).collect(Collectors.toList());
    }

    private WordsRelationWithInverse createInverseWordsRelations(WordsRelation wordsRelation) {
        WordsRelationWithInverse wordsRelationWithInverse = new WordsRelationWithInverse();
        wordsRelationWithInverse.setFirstWord(wordsRelation.getSecondWord());
        wordsRelationWithInverse.setSecondWord(wordsRelation.getFirstWord());
        wordsRelationWithInverse.setRelation(wordsRelation.getRelation());
        wordsRelationWithInverse.setInverse(true);
        return wordsRelationWithInverse;
    }
}
