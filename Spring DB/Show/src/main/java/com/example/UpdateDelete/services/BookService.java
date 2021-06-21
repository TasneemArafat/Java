package com.example.UpdateDelete.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.UpdateDelete.models.Book;
import com.example.UpdateDelete.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook =  bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}

	public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
		Book book = findBook(id);
		book.setTitle(title);
		book.setDescription(description);
		book.setLanguage(language);
		book.setNumberOfPages(numOfPages);
		bookRepository.save(book);
		return book;
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
	
}