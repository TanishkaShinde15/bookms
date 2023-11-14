package com.bookms.bookms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bookms.model.Book;


@RestController
public class BookmsController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Value("{$server.port}")
	private String port;
	 
	@GetMapping("fetchAllBookDetails")
	public ResponseEntity<List<Book>> fetchAllBookDetails(){
		
		return ResponseEntity.ok(bookRepository.findAll());
	}
	@GetMapping("/fetchSingleRecord/{isbn}")
	public ResponseEntity<Book>fetchSingleRecord(@PathVariable(value="isbn") String isbn){


        if (bookRepository.findById(isbn).isPresent())
        {
			return ResponseEntity.ok(bookRepository.findById(isbn).get());

        }
       else
        {
            return ResponseEntity.badRequest().body(null);
        }
}
	@PostMapping("createNewBookRecord")
	public ResponseEntity<String> createNewBookRecord(@RequestBody Book book){
		
		bookRepository.save(book);
		return ResponseEntity.ok("Created book record successfully:"+ port);
	}
	@DeleteMapping("deleteBook/{isbn}")
	public String deleteBookRecord(@PathVariable(value="isbn") String isbn){
		
		 if (bookRepository.findById(isbn) != null)   {
			 bookRepository.deleteById(isbn);
			 return "Deleted book record successfully";
	        }
		 else
	        {
	            return null;
	        }
	}
	
	@PutMapping("updateBook/{isbn}")
	public Book updateStudent(@RequestBody Book book,@PathVariable(value="isbn") String isbn){
		Book bookUpdate=bookRepository.findById(isbn).get();
		if(bookUpdate.getIsbn()!=null) {
			bookUpdate.setIssuedCopies(book.getIssuedCopies());
		}
		
			return this.bookRepository.save(bookUpdate);
	}

}
