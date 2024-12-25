package com.projects.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projects.entity.Book;
import com.projects.entity.MyBookList;
import com.projects.service.BookService;
import com.projects.service.MyBookListService;

@Controller
public class BooksController {
	@Autowired
	private BookService service;
	@Autowired
	private MyBookListService mservice;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_books")
	  public String showBooks(Model m) {
		  List<Book> book=service.getAllBook();
		  m.addAttribute("book", book);
		  
		  return "bookList";
	  }
  @PostMapping("/register")
  public String addBook(@ModelAttribute Book b) {
	  service.save(b);
	  return "redirect:/available_books";
  }
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable int id,Model m) {
	  Book book=service.getBookById(id);
	  m.addAttribute("book", book);
	  return "edit_book";
	  
  }
  @PostMapping("/update")
  public String updateBook(@ModelAttribute Book book) {
	  service.save(book);
	  System.out.println(book);
	  return "redirect:/available_books";
  }
  @GetMapping("/delete/{id}")
 public String deleteBook(@PathVariable int id,HttpSession session) {
	  service.deleteBook(id);
	  session.setAttribute("msg", "Book deleted successfuly---");
	return "redirect:/available_books";
  }
  @GetMapping("/my_books")
  public String getMyBooks(Model m) {
	  List<MyBookList>list=mservice.getAllMyBooks();
	  m.addAttribute("book", list);
	  return "myBooks";
  }
  @RequestMapping("/mylist/{id}")
  public String getMyList(@PathVariable("id") int id) {
	  Book b=service.getBookById(id);
	  MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
	  mservice.saveMyBooks(mb);
	  return "redirect:/my_books";
  }
}
