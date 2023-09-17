package me.erano.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.erano.com.dto.BookDto;
import me.erano.com.model.Book;
import me.erano.com.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	
	private final BookRepository bookRepository;
	
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;

		
	}

	@Override
	public void createBook(Book book) {
		bookRepository.saveAndFlush(book);
	}

	@Override
	public void updateBook(Long id, Book book) {
		bookRepository.deleteById(id);
		bookRepository.save(book);
		
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	

	@Override
	public BookDto getBook(Long id) {
		Book expected = bookRepository.getReferenceById(id);
		BookDto bookDto = new BookDto(
				expected.getId(),
				expected.getName(),
				expected.getAuthor().getId()
			);
		
		return bookDto;
	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
	    List<BookDto> bookDTOs = new ArrayList<>();

	    for (Book book : books) {
	        BookDto bookDTO = new BookDto();
	        bookDTO.setId(book.getId());
	        bookDTO.setName(book.getName());
	        bookDTO.setAuthorId(book.getAuthor().getId());
	        bookDTOs.add(bookDTO);
	    }

	    return bookDTOs;
	}

	
	
	

}
