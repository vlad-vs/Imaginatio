package com.imaginatio.booksHandler.TextResolverPackage;

import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.dao.AddBookToDataBaseDaoImpl;
import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.service.AddBookToBaseServiceImpl;
import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.entity.PageLink;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

public class BooksManipulationMain {

    public static void main(String[] args) {

        String bookToResolver = "C:\\Users\\HardWorker\\Desktop\\bookName.txt";
        String resolvedBook = "C:\\Users\\HardWorker\\Desktop\\resolvedBookName.txt";

        TextResolver bookResolver = new TextResolver();
        String s =  bookResolver.readBookFromTxtFile(bookToResolver);
        System.out.println(s);

        try(FileWriter writer = new FileWriter(resolvedBook, false))
        {
            writer.write(s);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}
