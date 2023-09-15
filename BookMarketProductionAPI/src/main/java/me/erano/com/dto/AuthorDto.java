package me.erano.com.dto;

import java.util.List;

import me.erano.com.model.Book;

public class AuthorDto {

	private Long id;

	private String name;
	
	private List<Book> books;
	
	public AuthorDto() {
		
	}
	
	public AuthorDto(Long id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	
	
	

}
