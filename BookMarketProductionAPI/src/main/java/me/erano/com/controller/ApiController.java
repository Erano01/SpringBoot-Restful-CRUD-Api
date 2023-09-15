package me.erano.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.erano.com.dto.AuthorDto;
import me.erano.com.dto.BookDto;
import me.erano.com.service.AuthorService;
import me.erano.com.service.BookService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/author")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<AuthorDto> authors = authorService.getAllAuthors();
        
        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content response
        } else {
            return ResponseEntity.ok(authors); // 200 OK response with the list of authors
        }
    }
	
	@GetMapping("/book")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content response
        } else {
            return ResponseEntity.ok(books); // 200 OK response with the list of books
        }
    }
	
}
