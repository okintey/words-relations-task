package com.example.wordsrelationstask.entity;

import com.example.wordsrelationstask.model.RelationsEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WordsRelationEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String firstWord;
    private String secondWord;
    private RelationsEnum relation;
}
