package com.example.BookAuthorManagement;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Repository;

import javax.print.attribute.HashAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {

    // book data
    HashMap<Long, Book> bookHashMap = new HashMap<>(); // bookid , book object /author

    // author data
    HashMap<Long, Author> authorHashMap = new HashMap<>(); //

    // author books link hashmap
    HashMap<String , List<Book>> authorBookHashMap = new HashMap<>();


    public String addBook(Book book) {
        // add book in bookHashmap

        Long key = book.getId();
        if (!bookHashMap.containsKey(key)){
            bookHashMap.put(key, book);
        }

        // add author in author map
        Long authorId = book.getAuthor().getId();
        if (!authorHashMap.containsKey(authorId)) {
            authorHashMap.put(authorId, book.getAuthor());
        }

        // adding author in authroBookHashmap
        String authorName = book.getAuthor().getName();
        // get all the books
        List<Book> bookList = authorBookHashMap.getOrDefault(authorName, new ArrayList<>());
        bookList.add(book);
        authorBookHashMap.put(authorName, bookList);
        return "Book added successfullly";
    }


    public String addAuthor(Author author) {
        // add author in author hashmap
        Long key = author.getId();
        if (!bookHashMap.containsKey(key)){
            authorHashMap.put(key, author);
        }
        return "Author added successfully";
    }

    public List<Book> allBooks() {
        return bookHashMap.values().stream().toList();
    }

    public String updateBooks(String name, Integer pages) {

        // update pages here in book object
        boolean isUpdated = false;

        for (Long key : bookHashMap.keySet()) {

            Book book = bookHashMap.get(key);

            if (book.getName().equals(name)) {
                book.setPages(pages);
                isUpdated = true;
            }
        }

        if (isUpdated) return "Book pages updated";
        return "Book not found";
    }


}
