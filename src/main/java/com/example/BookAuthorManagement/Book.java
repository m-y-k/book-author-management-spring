package com.example.BookAuthorManagement;

public class Book {

    private Long id;
    private String name;
    private int pages;
    private Author author;

    public Book(Long id, String name, int pages, Author author) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
