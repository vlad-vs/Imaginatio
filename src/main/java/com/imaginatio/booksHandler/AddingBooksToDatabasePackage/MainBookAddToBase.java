package com.imaginatio.booksHandler.AddingBooksToDatabasePackage;

import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.dao.AddBookToDataBaseDaoImpl;
import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.entity.PageLink;
import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.service.AddBookToBaseServiceImpl;
import com.imaginatio.entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainBookAddToBase {
    public static void main(String[] args) {

        String bookName = "Pohishenie";

        String autor = "Autor Jon";

//        String pathToFile = "C:/Java_Progect/Imaginatio/src/main/resources/books/pohishenie.txt";
        String pathToFile = "C:\\Users\\HardWorker\\Desktop\\new2.txt";

        String cover = "cover.jpg";

        String bookDescription = "Это необычная, книга. Не пытайся читать ее по порядку с начала до конца, переходя от одной страницы к другой, — ничего не получится! Ведь это игра, где тебя ждет множество приключений, — на этот раз тебя похитили террористы. Время от времени тебе придется делать выбор. Что принесет он? Успех или поражение?</p>\n" +
                "<p>Твои приключения — результат твоего выбора. Тебе самому решать, куда пойти, что сделать. А дальше — читай указания в конце страницы, и тогда узнаешь, к чему приведет твой выбор.</p>\n" +
                "<p>И помни: назад пути нет! Поэтому хорошенько подумай, прежде чем действовать. Игра есть игра: ты можешь проиграть, а можешь и выиграть!</p>";

        Book book = new Book(bookName,autor,cover,bookDescription);

        ApplicationContext context = new ClassPathXmlApplicationContext("bookHandlerSpringConfig/aplicationContext.xml");
// книга по страницам
        AddBookToBaseServiceImpl service = context.getBean("addBookToBaseServiceImpl",AddBookToBaseServiceImpl.class);
        String text = service.readBookFromTxtFile(pathToFile);
        LinkedHashMap<Integer, String> bookByPages = service.splitBookToPages(text);
// получение листа линков
        ArrayList<PageLink> pageAndLinks = service.readLinksFromPage(bookByPages);
// линки в базу
        AddBookToDataBaseDaoImpl dao = context.getBean("addBookDao", AddBookToDataBaseDaoImpl.class);
        dao.insertArrayListLinks(pageAndLinks,bookName);

// очистка книги от линков и добавление книги в базу
        toBase(service, bookByPages, dao, bookName);

// добавление названия книги в базу
        dao.addBook(book);
    }

    private static void toBase(AddBookToBaseServiceImpl service, LinkedHashMap<Integer, String> bookByPages, AddBookToDataBaseDaoImpl dao,String bookName) {
        int number=1;
        for (int i = 1; i <= bookByPages.size(); i++) {
//            String psge = service.cleanPageFromLinks(bookByPages.get(i));
            String page = bookByPages.get(i);
            String pageImgPath = service.readImegeFromPage(page);

            page = service.cleanLinks(page);
//            page = service.cleanImg(page);
            dao.addPage(i,page,bookName,pageImgPath);
            System.out.println(number + " book page => ok");
            number++;
        }
    }
}
