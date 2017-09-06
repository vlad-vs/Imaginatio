package com.imaginatio.dao;

import java.util.List;

public interface PagesDao {

    public Object getPageText(int page, String bookName);

    public List getPageLinks(int page, String bookName);

    public List getBookByID(int id);

    public List getBookByName(String name);

    public List getBookAllBooks();

}
