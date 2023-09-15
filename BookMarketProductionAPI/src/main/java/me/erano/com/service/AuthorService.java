package me.erano.com.service;

import java.util.List;

import me.erano.com.dto.AuthorDto;
import me.erano.com.model.Author;

public interface AuthorService {

	public abstract void createAuthor(Author author);

	public abstract void updateAuthor(Long id, Author author) throws Exception;

	public abstract void deleteAuthor(Long id);

	public abstract List<AuthorDto> getAllAuthors();

}
