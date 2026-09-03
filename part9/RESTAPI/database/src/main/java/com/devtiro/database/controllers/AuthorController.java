package com.devtiro.database.controllers;

import com.devtiro.database.domain.dto.AuthorDto;
import com.devtiro.database.domain.entities.AuthorEntity;
import com.devtiro.database.mappers.Mapper;
import com.devtiro.database.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController // This is just a controller, but we are specefically telling spring we are building a REST API. Hence REST controller
public class AuthorController {

    private AuthorService authorService; // Now our controller can communciate with service. As so... Controller <=> Service

    private Mapper<AuthorEntity, AuthorDto> authorMapper; // Now we can implement our mapper to make DTO to Entity connection

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors") // REMEBER FROM LAST PROJECT: PostMapping relates to HTTP POST
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) { // We changed this to AuthorDTO to prevent our Presenation layer from communicating with Persistance Layer
        AuthorEntity authorEntity = authorMapper.mapFrom(author); // So now are main entity has information from DTO instead of persistence layer
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED); // Respond back to Http request
    }

    @GetMapping(path = "/authors") // HTTP GET
    public List<AuthorDto> listAuthors() {
        List<AuthorEntity> authors = authorService.findAll();
        return authors.stream()
                .map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") Long id) {
        Optional<AuthorEntity> foundAuthor = authorService.findOne(id);
        return foundAuthor.map(authorEntity -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
