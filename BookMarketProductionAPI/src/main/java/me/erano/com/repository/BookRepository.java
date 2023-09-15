package me.erano.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.erano.com.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
