package me.erano.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Book getBook(Long id) {
		return bookRepository.getReferenceById(id);
	}

	@Override
	public List<Book> getAllBooks() {
	    return bookRepository.findAll();
	}

	
	
	

}
