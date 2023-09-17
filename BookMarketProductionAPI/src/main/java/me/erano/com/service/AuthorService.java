package me.erano.com.service;

import java.util.List;

import me.erano.com.dto.AuthorDto;
import me.erano.com.model.Author;

public interface AuthorService {

	public abstract Author createAuthor(AuthorDto authorDto);

	public abstract void updateAuthor(Long id, Author author) throws Exception;

	public abstract void deleteAuthor(Long id);
	
	public abstract AuthorDto getAuthor(Long id);

	public abstract List<AuthorDto> getAllAuthors();

}
