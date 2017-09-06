package com.imaginatio.booksHandler.AddingBooksToDatabasePackage.dao;

import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.entity.PageLink;
import com.imaginatio.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.ArrayList;

@Repository("addBookDao")
public class AddBookToDataBaseDaoImpl {

    private NamedParameterJdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void insert(PageLink link, String bookName) {
        String sql = "INSERT INTO links (CURRENT_PAGE,LINK_DESCRIPTION,LINK_TO_PAGE,BOOK_NAME) VALUES (:CURRENT_PAGE,:LINK_DESCRIPTION,:LINK_TO_PAGE,:BOOK_NAME)";
//        String sql = "INSERT INTO imaginatio_test.links (CURRENT_PAGE,LINK_DESCRIPTION,LINK_TO_PAGE) VALUES (:CURRENT_PAGE,:LINK_DESCRIPTION,:LINK_TO_PAGE)";
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("CURRENT_PAGE",link.getCurrentPageNumber());
        parameter.addValue("LINK_DESCRIPTION",link.getText());
        parameter.addValue("LINK_TO_PAGE",link.getPage());
        parameter.addValue("BOOK_NAME",bookName);
        jdbcTemplate.update(sql,parameter);
    }

    public void insertArrayListLinks(ArrayList<PageLink> links, String bookName){
        int number = 0;
        for (PageLink link : links) {
            insert(link,bookName);
            System.out.println(number + " => ok");
            number++;
        }
    }

    public void addPage(int number, String page,String bookName,String pageImgPath) {
        String sql = "INSERT INTO pages (PAGE_NUMBER,BOOK_NAME,TEXT,PAGE_IMG_PATH) VALUES (:PAGE_NUMBER,:BOOK_NAME,:TEXT,:PAGE_IMG_PATH)";
//        String sql = "INSERT INTO TEXT_BOOK (PAGE_NUMBER,PAGE_TEXT) VALUES (:PAGE_NUMBER,:PAGE_TEXT)";
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("PAGE_NUMBER",number);
        parameter.addValue("BOOK_NAME",bookName);
        parameter.addValue("TEXT",page);
        parameter.addValue("PAGE_IMG_PATH",pageImgPath);
        jdbcTemplate.update(sql,parameter);
    }

    public void addBook(Book book){
        String sql = "INSERT INTO books(NAME,AUTHOR,BOOK_COVER_NAME,BOOK_DESCRIPTION) VALUES (:bookName,:Autor,:Cover,:Description)";
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("bookName",book.getName());
        parameter.addValue("Autor",book.getAuthor());
        parameter.addValue("Cover",book.getBookCoverName());
        parameter.addValue("Description",book.getBookDescription());
        jdbcTemplate.update(sql,parameter);
    }

}
