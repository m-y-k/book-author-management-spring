package com.example.BookAuthorManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    // all apis

    // API 1 - add book
    @PostMapping("/add")
    public String addBook(Book book) {
        return bookService.addBook(book);
    }


    // API 2 - add author
    @PostMapping("/add-author")
    public String addAuthor(Author author) {
        return bookService.addAuthor(author);
    }

    // API - 3 -> GET API  : Find the bookName with highest no. of pages.
    @GetMapping("/highest-pages")
    public Book highestNoOfPages() {
        return bookService.highestNoOfPages();
    }

    // API - 4   -> PUT API : Update the number of pages for a specific book by specifying its name in the path and providing the updated number of pages.
    @PutMapping("/update-pages")
    public String updatePages(@PathVariable("name") String name,
                              @PathVariable("pages") Integer pages) {

        return bookService.updatePages(name, pages);

    }

    // API - 5 -> GET API:  Find out total no. the books who’s authors have rating greater than x
    @GetMapping("author-rating")
    public int authorRating(@RequestParam("rating") Integer rating) {
        return bookService.authorRating(rating);
    }

}
