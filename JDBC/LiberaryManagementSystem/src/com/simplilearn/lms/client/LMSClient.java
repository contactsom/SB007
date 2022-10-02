package com.simplilearn.lms.client;

import com.simplilearn.lms.book.Book;
import com.simplilearn.lms.service.BookService;

public class LMSClient {

	public static void main(String[] args) {
		
		/*1. Verify the Users */
		
		BookService bookService = new BookService();
		/*String status=bookService.verifyUser("admin1","admin@1234"); // Success
		//String status=bookService.verifyUser("admin1","admin@1234"); // Fail
		System.out.println(status);*/
		
		
		/*2. Add book in to portal*/
		Book book = new Book(901, "Web Technologies: Black Book", "Kogent Learning Solutions Inc. ", "Dreamtech Press", 480, 45930);
		int record=bookService.addBooks(book);
		System.out.println(record+" No of Record Inserted Sussessfully");
		
		//Home Work
		/*3. Update the Book*/
		
		/*4. Delete the Book*/
		
	}
}
