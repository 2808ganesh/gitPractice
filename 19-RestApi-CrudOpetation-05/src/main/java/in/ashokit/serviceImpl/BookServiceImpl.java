package in.ashokit.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Book;
import in.ashokit.reop.BookRepo;
import in.ashokit.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepo bookRepo;
	
	public BookServiceImpl(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public String upsertData(Book book) {
		
		Integer bookId = book.getBookId();
		
		System.out.println(bookId);
		 Book save = bookRepo.save(book);
		 
		 System.out.println(bookId);
		 if(bookId == null) {
			 return "Data Saved Successfully";
		 }else {
		
		return "Data Updated successfully";
		 }
	}

	@Override
	public List<Book> getAllBooks() {

		
		return bookRepo.findAll();
	}

	@Override
	public String deleteBook(Integer bookId) {

		bookRepo.deleteById(bookId);
		
		return "Book Deleted";
	}

}
