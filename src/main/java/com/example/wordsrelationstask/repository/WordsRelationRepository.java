package com.example.wordsrelationstask.repository;

import com.example.wordsrelationstask.entity.WordsRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsRelationRepository extends CrudRepository<WordsRelationEntity, Long> {

    WordsRelationEntity save(WordsRelationEntity entity);
    List<WordsRelationEntity> findAll();

    List<WordsRelationEntity> findAllByRelation(String relation);
}
