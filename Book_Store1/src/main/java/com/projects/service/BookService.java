package com.projects.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.entity.Book;
import com.projects.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private  BookRepository repo;
	public void save(Book b) {
		repo.save(b);
		
	}
	public List<Book> getAllBook(){
		return repo.findAll();
	}
	public Book getBookById(int id) {
		Optional<Book>book= repo.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		return null;
	}
	public void deleteBook(int id) {
		repo.deleteById(id);
	}
   
}
