package me.erano.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.erano.com.dto.AuthorDto;
import me.erano.com.model.Author;
import me.erano.com.model.Book;
import me.erano.com.repository.AuthorRepository;
import me.erano.com.repository.BookRepository;

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
	public Author createAuthor(AuthorDto authorDto) {
		if(!authorRepository.existsById(authorDto.getId())) {
			Author author = new Author();
			author.setId(authorDto.getId());
			author.setName(authorDto.getName());
			author.setBooks(authorDto.getBooks());
			try {
				authorRepository.saveAndFlush(author);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return author;
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
	public AuthorDto getAuthor(Long id) {
		Author expected = authorRepository.getReferenceById(id);
		AuthorDto authorDto = new AuthorDto(
				expected.getId(),
				expected.getName(),
				expected.getBooks()
				);
		return authorDto;
	}

	@Override
	public List<AuthorDto> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		List<AuthorDto> authorDtos = new ArrayList<>();
		for(Author author : authors) {
			AuthorDto authorDto = new AuthorDto(author.getId(),author.getName(),author.getBooks());
			authorDtos.add(authorDto);
		}
		
		return authorDtos;
	}
}
