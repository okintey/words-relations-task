package com.example.wordsrelationstask.config;

import com.example.wordsrelationstask.entity.WordsRelationEntity;
import com.example.wordsrelationstask.model.WordsRelation;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        Converter<String, String> toLowerCaseConverter = context -> context.getSource().toLowerCase();
        PropertyMap<WordsRelationEntity, WordsRelation> itemMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(toLowerCaseConverter).map(source.getFirstWord(), destination.getFirstWord());
                using(toLowerCaseConverter).map(source.getSecondWord(), destination.getSecondWord());
            }
        };
        modelMapper.addMappings(itemMap);
        return modelMapper;
    }
}
