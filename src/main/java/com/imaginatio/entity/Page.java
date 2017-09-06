package com.imaginatio.entity;
import javax.persistence.*;
@Entity
@Table(name = "PAGES")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="PAGE_ID")
    private int id;

    @Column(name = "PAGE_NUMBER")
    private int number;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "PAGE_IMG_PATH")
    private String pageImgName;

    public Page() {
    }

    public String getPageImgName() {
        return pageImgName;
    }

    public void setPageImgName(String pageImgName) {
        this.pageImgName = pageImgName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", number=" + number +
                ", text='" + text + '\'' +
                '}';
    }
}
