package com.imaginatio.booksHandler.AddingBooksToDatabasePackage.entity;

public class PageLink {

    int currentPageNumber;

    String text;

    int page;

    public PageLink() {
    }

    public PageLink(int currentPageNumber, String text, int page) {
        this.currentPageNumber = currentPageNumber;
        this.text = text;
        this.page = page;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    @Override
    public String toString() {
        return "PageLink{" +
                "currentPageNumber=" + currentPageNumber +
                ", text='" + text + '\'' +
                ", page=" + page +
                '}';
    }
}
