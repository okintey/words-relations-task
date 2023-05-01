package com.example.wordsrelationstask.repository;

import com.example.wordsrelationstask.entity.WordsRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRelationRepository extends CrudRepository<WordsRelationEntity, Long> {

    WordsRelationEntity save(WordsRelationEntity entity);
}
