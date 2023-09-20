package me.erano.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.erano.com.model.Author;
import me.erano.com.model.Book;
import me.erano.com.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	
	private final AuthorRepository authorRepository;
	
	
	@Autowired
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
		// Create and initialize Author and Book objects
        Author author1 = new Author();
        author1.setName("Erich Gamma");
        Book book1 = new Book();
        book1.setName("Design Patterns GoF");
        book1.setAuthor(author1);
        Book book2 = new Book();
        book2.setName("Design Patterns GoF 2");
        book2.setAuthor(author1);
        author1.setBooks(List.of(book1, book2));

        Author author2 = new Author();
        author2.setName("Kodlab");
        Book book3 = new Book();
        book3.setName("Temel Elektronik");
        book3.setAuthor(author2);
        Book book4 = new Book();
        book4.setName("Java ile Android Programlama");
        book4.setAuthor(author2);
        author2.setBooks(List.of(book3, book4));

        // Persist the Author objects to the database
        authorRepository.saveAndFlush(author1);
        authorRepository.saveAndFlush(author2);
	}
	
	@Override
	public Author createAuthor(Author author) {
		if(!authorRepository.existsById(author.getId())) {
			Author newAuthor = new Author();
			newAuthor.setId(author.getId());
			newAuthor.setName(author.getName());
			newAuthor.setBooks(author.getBooks());
			try {
				authorRepository.saveAndFlush(newAuthor);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return newAuthor;
		}
		
		return null;
	}

	@Override
	public void updateAuthor(Long id, Author updatedAuthor) throws Exception {
	    Optional<Author> existingAuthor = authorRepository.findById(id);
	    if (existingAuthor.isPresent()) {
	        Author author = existingAuthor.get();
	        author.setName(updatedAuthor.getName()); // Update author properties as needed
	        authorRepository.saveAndFlush(author);
	    } else {
	        // Handle the case where the author with the given ID is not found
	        throw new Exception("Author not found with ID: " + id);
	    }
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}

	@Override
	public Author getAuthor(Long id) {
		Author expected = authorRepository.getReferenceById(id);
		return expected;
	}
	public Author getAuthorByName(String name) {
		Author expected = authorRepository.findAuthorByName(name);
		return expected;
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}
}
