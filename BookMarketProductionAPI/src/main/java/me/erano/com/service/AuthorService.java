package me.erano.com.service;

import java.util.List;

import me.erano.com.model.Author;

public interface AuthorService {

	public abstract Author createAuthor(Author author);

	public abstract void updateAuthor(Long id, Author author) throws Exception;

	public abstract void deleteAuthor(Long id);
	
	public abstract Author getAuthor(Long id);
	
	public abstract Author getAuthorByName(String name);

	public abstract List<Author> getAllAuthors();

}
