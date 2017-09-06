package com.imaginatio.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private int id;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PATH")
    private String path;

    @Column(name = "BOOK_COVER_NAME")
    private String bookCoverName;

    @Column(name = "BOOK_DESCRIPTION")
    private String bookDescription;

    public Book() {
    }

    public Book(String name, String author, String bookCoverName, String bookDescription) {
        Name = name;
        this.author = author;
        this.bookCoverName = bookCoverName;
        this.bookDescription = bookDescription;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookCoverName() {
        return bookCoverName;
    }

    public void setBookCoverName(String bookCoverName) {
        this.bookCoverName = bookCoverName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", author='" + author + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
