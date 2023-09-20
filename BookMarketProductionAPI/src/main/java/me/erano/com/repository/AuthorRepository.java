package me.erano.com.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import me.erano.com.model.Author;

//cross origin sonra eklenecek

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author,Long>{

	// localhost:8080/api/author?authorName=asd
	@Query("SELECT a FROM Author a WHERE a.name = :authorName")
	Author findAuthorByName(@Param("authorName") String authorName);
	
	

	
}
