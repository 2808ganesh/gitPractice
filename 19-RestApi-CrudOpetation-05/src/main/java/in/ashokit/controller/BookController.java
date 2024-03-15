package in.ashokit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Book;
import in.ashokit.serviceImpl.BookServiceImpl;

@RestController
public class BookController {

	private BookServiceImpl bookServiceImpl;

	public BookController(BookServiceImpl bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	@PostMapping("/book")
	public ResponseEntity<String> insertBookData(@RequestBody Book book) {

		

		

		System.out.println("ganesh changes");
                                      System.out.println("Changes done");

		String msg = bookServiceImpl.upsertData(book);
		System.out.println("All Changes done");
		System.out.println("ganesh changes");

		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> allBooks = bookServiceImpl.getAllBooks();

		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}
	
	@PutMapping("/book")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		
		String msg = bookServiceImpl.upsertData(book);
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
		
		
		String msg = bookServiceImpl.deleteBook(bookId);
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
}
