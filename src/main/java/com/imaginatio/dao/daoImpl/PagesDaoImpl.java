package com.imaginatio.dao.daoImpl;



import com.imaginatio.dao.PagesDao;
import com.imaginatio.entity.Book;
import com.imaginatio.entity.Links;
import com.imaginatio.entity.Page;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("pagesDaoImpl")
public class PagesDaoImpl implements PagesDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Object getPageText(int page, String bookName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM pages WHERE  PAGE_NUMBER=:page AND BOOK_NAME=:book",Page.class);
        query.setParameter("page", page);
        query.setParameter("book", bookName);
        return query.getSingleResult();
    }

    @Transactional(readOnly = true)
    public List getPageLinks(int page, String bookName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM links WHERE CURRENT_PAGE =:page AND  BOOK_NAME =:book",Links.class);
        query.setParameter("page",page);
        query.setParameter("book",bookName);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List getBookByID(int id) {
        return entityManager.createNativeQuery("SELECT * FROM books WHERE BOOK_ID =:id",Book.class)
                .setParameter("id",id).getResultList();
    }

    @Transactional(readOnly = true)
    public List getBookByName(String name) {
        return entityManager.createNativeQuery("SELECT * FROM books WHERE NAME=:name",Book.class)
                .setParameter("name",name).getResultList();
    }

    @Transactional(readOnly = true)
    public List getBookAllBooks() {
        return entityManager.createNativeQuery("SELECT * FROM books",Book.class).getResultList();
    }

}
