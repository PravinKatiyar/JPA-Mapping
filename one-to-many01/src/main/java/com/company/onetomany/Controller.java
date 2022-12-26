package com.company.onetomany;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private PageRepo pageRepo;

	@PostMapping(value = "/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = bookRepo.save(book);
		return new ResponseEntity<Book>(b, HttpStatus.OK);

	}

	@PostMapping(value = "/book/{bookId}/page")
	public ResponseEntity<Book> addPageToBook(@PathVariable("bookId") Integer bookid, @RequestBody Page page) {
		//Fetch Book from db
		Optional<Book> b = bookRepo.findById(bookid);
		Book book = b.get();
		//add pages to book
		book.getPages().add(page);
		//Set book for the page
		page.setBook(book);
		//sae the book
		return new ResponseEntity<Book>(bookRepo.save(book), HttpStatus.OK);

	}
	
	@GetMapping(value="/details")
	public Book getAll(@PathParam("bookid") Integer bookid) {
		return bookRepo.findTitleAndAuthorById(bookid);
		
	}

}
