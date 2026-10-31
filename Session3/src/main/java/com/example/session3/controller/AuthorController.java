package com.example.session3.controller;

import com.example.session3.model.Author;
import com.example.session3.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthor();
    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody Author author){
        if (author.getId() == null) {
            return ResponseEntity.badRequest().body("ID tác giả không được để trống");
        }
        Author createdAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }
}
