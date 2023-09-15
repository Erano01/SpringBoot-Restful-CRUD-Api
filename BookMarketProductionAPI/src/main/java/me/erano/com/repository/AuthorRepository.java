package me.erano.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.erano.com.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{

	Author findByName(String authorName);

}
