package com.example.wordsrelationstask.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WordsRelation {
    @NotEmpty
    private String firstWord;
    @NotEmpty
    private String secondWord;
    @NotNull
    private RelationsEnum relation;
}
