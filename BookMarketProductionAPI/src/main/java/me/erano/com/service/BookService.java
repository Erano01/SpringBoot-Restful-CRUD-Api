package me.erano.com.service;

import java.util.List;

import me.erano.com.model.Book;

public interface BookService {

	public abstract void createBook(Book book);

	public abstract void updateBook(Long id, Book book);

	public abstract void deleteBook(Long id);
	
	public abstract Book getBook(Long id);

	public abstract List<Book> getAllBooks();
}
