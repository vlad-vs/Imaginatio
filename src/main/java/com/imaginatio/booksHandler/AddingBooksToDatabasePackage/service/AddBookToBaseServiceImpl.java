package com.imaginatio.booksHandler.AddingBooksToDatabasePackage.service;

import com.imaginatio.booksHandler.AddingBooksToDatabasePackage.entity.PageLink;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HardWorker on 17.04.2017.
 */
@Component
public class AddBookToBaseServiceImpl {

    LinkedHashMap<Integer, String> bookPages = new LinkedHashMap<>();

    public AddBookToBaseServiceImpl() {

    }

    public LinkedHashMap<Integer, String> splitBookToPages(String textBook) {
        int pageNumber = 1;
        int nextPageNumber = 2;
        int firstIndexPage, secondIndexPage;
        while (true) {
            int tadLengh = ("-" + pageNumber + "-").length();
            firstIndexPage = textBook.indexOf("-" + pageNumber + "-") + tadLengh;
            secondIndexPage = textBook.indexOf("-" + nextPageNumber + "-");
            String pageText = textBook.substring(firstIndexPage, secondIndexPage);
            bookPages.put(pageNumber, pageText);
            pageNumber++;
            nextPageNumber++;
            if (!textBook.contains("-" + nextPageNumber + "-")) {
                break;
            }
        }
        return bookPages;
    }

    private String getLineLinksWithTegs(String page, String openTextLinkTeg, String closeTextLinkTeg) {
        int firstIndexPage = page.indexOf(openTextLinkTeg);
        int secondIndexPage = page.indexOf(closeTextLinkTeg) + closeTextLinkTeg.length();

        return page.substring(firstIndexPage, secondIndexPage);
    }

    public String readBookFromTxtFile(String pathToFile) {
        BufferedReader reader;
        StringBuilder stringBuilder = null;
        try {
            reader = new BufferedReader(new FileReader(pathToFile));
            String readLine;
            stringBuilder = new StringBuilder();
            while ((readLine = reader.readLine()) != null) {
                stringBuilder.append(readLine).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public ArrayList<PageLink> readLinksFromPage(LinkedHashMap<Integer, String> splitBookToPages) {
        ArrayList<PageLink> pageLinks = new ArrayList<>();
        for (int i = 1; i <= splitBookToPages.size(); i++) {
            String textPage = splitBookToPages.get(i);
            Matcher matcher = Pattern.compile("<links>(.+)<\\/links><page>(.+)<\\/page>").matcher(textPage);
            while (matcher.find()) {
                PageLink pageLink = new PageLink();
                pageLink.setCurrentPageNumber(i);
                pageLink.setText(matcher.group(1));
                pageLink.setPage(Integer.parseInt(matcher.group(2)));
                pageLinks.add(pageLink);
            }
        }
        return pageLinks;
    }

    public String readImegeFromPage(String page) {
        String pageImg = null;
        Matcher matcher = Pattern.compile("(<image l:href=\"#((i_\\d+)[.](.+))[\"])(\\/>)").matcher(page);
        if (matcher.find()) {
            pageImg = matcher.group(2);
        }
        return pageImg;
    }

    public String cleanLinks(String page) {
        Pattern p = Pattern.compile("(.*)(<startLinks>)(.*)(<endLinks>)");
        Matcher matcher = p.matcher(page);
        if (matcher.find()) {
            page = matcher.group(1);
        } else {
            page = page.replace("<startLinks>", "");
            page = page.replace("<endLinks>", "");
            page = page.replaceAll("<links>(.*)</page>", "");
        }
        return page;
    }


// old
    public LinkedHashMap<Integer, String> getBookPages() {
        return bookPages;
    }

    public void setBookPages(LinkedHashMap<Integer, String> bookPages) {
        this.bookPages = bookPages;
    }

    private String getPage(int page) {
        return bookPages.get(page);
    }

    public String cleanPageFromLinks(String page) {
        String cleanText;
        String textToDelete = getLineLinksWithTegs(page, "<startLinks>", "<endLinks>");
        cleanText = page.replace(textToDelete, "");
        return cleanText;
    }

    public String getLineLinksNoTegs(String page, String openTextLinkTeg, String closeTextLinkTeg) {
        int firstIndexPage = page.indexOf(openTextLinkTeg) + openTextLinkTeg.length();
        int secondIndexPage = page.indexOf(closeTextLinkTeg);

        return page.substring(firstIndexPage, secondIndexPage);
    }

    public String cleanImg(String page) {
        Pattern p = Pattern.compile("(.*)(<image l:href=\"#((i_\\d+)[.](.+))[\"])(\\/>)");
        Matcher matcher = p.matcher(page);
        if (matcher.find()) {
            page = matcher.group(1);
        }
        return page;
    }

    public String convertToUtf(String stringToConvertUtfFormat) {
        String textInUtfFormat = null;
        try {
            textInUtfFormat = new String(stringToConvertUtfFormat.getBytes(), "UTF-8");
            textInUtfFormat = textInUtfFormat.replace("�?", "И");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return textInUtfFormat;
    }
}
