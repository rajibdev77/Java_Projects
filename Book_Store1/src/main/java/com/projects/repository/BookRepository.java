package com.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
