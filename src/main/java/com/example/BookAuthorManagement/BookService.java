package com.example.BookAuthorManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public String addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public String addAuthor(Author author) {
        return bookRepository.addAuthor(author);
    }

    public Book highestNoOfPages() {
        // getting all books
        List<Book> bookList = bookRepository.allBooks();

        // filter book as needed
        Book ansBook = null;
        int pages = 0;

        for (Book book : bookList) {

            int noOfPages = book.getPages();

            if (noOfPages > pages) {
                pages = noOfPages;
                ansBook = book;
            }
        }
        return ansBook;
    }

    public String updatePages(String name, Integer pages) {
        return bookRepository.updateBooks(name, pages);
    }


    public int authorRating(Integer x) {

        List<Book> bookList = bookRepository.allBooks();
        int books = 0;

        // filter by author rating in books
        for (Book book : bookList) {
            if (book.getAuthor().getRating() > x) {
                books++;
            }
        }
        return books;
    }
}
// JPA - mySQL
// oops, dsa, jvm, jre, jdk  theory