package com.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.entity.MyBookList;
import com.projects.repository.MyBookRepository;

@Service
public class MyBookListService {
	@Autowired
	private MyBookRepository mrepo;
	
	public void saveMyBooks(MyBookList book) {
		mrepo.save(book);
	}
 public List<MyBookList> getAllMyBooks(){
	 return mrepo.findAll();
 }
}
