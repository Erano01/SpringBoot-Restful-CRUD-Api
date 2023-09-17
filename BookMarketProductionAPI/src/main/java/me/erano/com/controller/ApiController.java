package me.erano.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.erano.com.dto.AuthorDto;
import me.erano.com.dto.BookDto;
import me.erano.com.model.Author;
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
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }
	
	// example : (GET) localhost:8080/api/author/1
	
	@GetMapping("/author/{id}")
	public ResponseEntity<AuthorDto> getAuthor(@PathVariable Long id){
		AuthorDto author = authorService.getAuthor(id);
		if (author == null) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(author); 
	    }
	}
	
	
	//example : (GET) localhost:8080/api/book/6
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
	    BookDto book = bookService.getBook(id);
	    
	    if (book == null) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(book); 
	    }
	}
	
	@PostMapping("/author")
	public ResponseEntity postAuthor(@RequestBody AuthorDto authorDto){
		//post edilecek json verisi aşağıdalar gibi olabilmeli
//		{
//		    "name": "Erich Gamma",
//		    "books": []
//		}
		
//		{
//	    "name": "Erich Gamma",
//	    "books": [//burada book nesneleri]
//	}
		Author savedAuthor = authorService.createAuthor(authorDto);
		
		if(savedAuthor == null) {
			return ResponseEntity.badRequest().build();
		}
		else {
			HttpHeaders headers = new HttpHeaders();
			
			headers.add("Location", 
					"/api/author"+savedAuthor.getId().toString());
			
			return new ResponseEntity(headers,HttpStatus.CREATED);
		}
	}
	
}
