package com.imaginatio.controllers;

import com.imaginatio.dao.daoImpl.PagesDaoImpl;
import com.imaginatio.entity.Book;
import com.imaginatio.entity.Links;
import com.imaginatio.entity.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    @Qualifier ("pagesDaoImpl")
    PagesDaoImpl dao;

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String firstPage(Model model) {
        logger.info("==============================PageController => firstPage => start=end");
        return "index";
    }

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public String booksPage(Model model) {
        // (заменить на аспекты)
        logger.info("==============================PageController => booksPage => start" );
        List<Book> books = dao.getBookAllBooks();
        model.addAttribute("books",books);
        logger.info("==============================PageController => booksPage => end");
        return "books";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        logger.info("==============================PageController => login => start=end" );
        return "login";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.info("==============================PageController => register => start=end" );
        return "register";
    }

    @RequestMapping("/logout")
    public String showLogout(){
        logger.info("==============================PageController => showLogout => start=end" );
        return "logout";
    }

    @RequestMapping(path = "/{bookName}/page/{pageNumber}", method = RequestMethod.GET)
    public String getPage(@PathVariable String bookName,@PathVariable int pageNumber, Model model) {
        logger.info("==============================PageController => getPage => start" );
        if (pageNumber== 0){pageNumber=1;}
        Page page = (Page) dao.getPageText(pageNumber, bookName);
// если страница меньше 1 то вывод первой
        if (pageNumber < 1) {
            page = (Page) dao.getPageText(1,bookName);
            model.addAttribute("page", page);
            List<Links> links = dao.getPageLinks(1, bookName);
            model.addAttribute("links", links);
            return "bookPage";
        }
// если страницы нет то это конец книги
        if (page == null) {
            return "lastBookPage";
        }
// получение новой страницы
        else {
            model.addAttribute("page", page);
            List<Links> links = dao.getPageLinks(pageNumber,bookName);
            model.addAttribute("links",links);
        }
        logger.info("==============================PageController => getPage => end");
        return "bookPage";
    }
}
