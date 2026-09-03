package com.devtiro.database.mappers.impl;

import com.devtiro.database.domain.dto.AuthorDto;
import com.devtiro.database.domain.entities.AuthorEntity;
import com.devtiro.database.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component // Help us inject all beans here for us
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> { // Connect 2 classes Entity <=> DTO

    private ModelMapper modelMapper;// Inject the mapper since we need it to work on our classes

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
// The 2 methods below are our connectors
    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) { 
        return modelMapper.map(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
