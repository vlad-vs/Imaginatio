package com.imaginatio.booksHandler.TextResolverPackage;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TextResolver {

    public String readBookFromTxtFile(String pathToFile) {
        int page = 0;
        BufferedReader reader;
        StringBuilder stringBuilder = null;
        try {
            reader = new BufferedReader(new FileReader(pathToFile));
            String readLine;
            stringBuilder = new StringBuilder();
            while ((readLine = reader.readLine()) != null) {
                int pageNumber = Integer.parseInt(getPageNumberRegex(readLine));
                if (pageNumber > 0){
                    page = pageNumber;
                }
                String pageToText = Integer.toString(page+1);
                readLine = pageNumberRegex(readLine);
                readLine = readLine.replace("<empty-line/>","").trim();
                readLine = readLine.replaceAll("<title>|</title>","").trim();
                readLine = readLine.replace("</section>","").trim();
                readLine = readLine.replace("</section>","").trim();
                readLine = readLine.replaceAll("<section .*>","").trim();
                readLine = readLine.replaceAll("<cite>|</cite>","").trim();
                readLine = getLinkNextPage_1(readLine);
                readLine = etLinkNextPage_3(readLine);
                readLine = etLinkNextPage_5(readLine,pageToText);
                readLine = etLinkNextPage_6(readLine,pageToText);
                readLine = etLinkNextPage_4(readLine);
                readLine = etLinkNextPage_2(readLine);
                readLine = backToPoint(readLine);
                readLine = theEnd(readLine,Integer.toString(page));
                stringBuilder.append(readLine).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private String delEnd(String line) {
        Pattern p = Pattern.compile("(<binary)(.*)(</binary>)");
        Matcher matcher = p.matcher(line);
        if (matcher.find()){
            line = "";
        }
        return line;
    }

    private String pageNumberRegex(String line){
        Pattern p = Pattern.compile("(<p>)+(\\d+)+(<\\/p>)");
        Matcher matcher = p.matcher(line);
        if (matcher.find()){
            line = "-" + matcher.group(2).trim() + "-";
        }
        return line;
    }

    private String getPageNumberRegex(String line){
        String pageNumber = "0";
        Pattern p = Pattern.compile("(<p>)+(\\d+)+(<\\/p>)");
        Matcher matcher = p.matcher(line);
        if (matcher.find()){
            pageNumber = matcher.group(2).trim();
        }
        return pageNumber;
    }

    private String getLinkNextPage_1(String line){
        Pattern p = Pattern.compile("(<p>)(Открой страницу) (\\d+)[.](<a l:href=\"#n_)(\\d+).*(<\\/p>)");
        Matcher matcher = p.matcher(line);

        if (matcher.find()) {
            String linkToPage = matcher.group(5);

            return "<startLinks>" + "\n"
                    + "<links>" + "Сдующая страница" + "</links>" + "<page>" + linkToPage + "</page>" + "\n"
                    + "<endLinks>";
        }else
            return line;
    }

    private String etLinkNextPage_2(String line){
        Pattern p = Pattern.compile("(<p>)(Переходи на страницу) (\\d+)[.](<a l:href=\"#n_)(\\d+).*(<\\/p>)");
        Matcher matcher = p.matcher(line);

        if (matcher.find()) {
            String linkToPage = matcher.group(5);

            return "<startLinks>" + "\n"
                    + "<links>" + "Сдующая страница" + "</links>" + "<page>" + linkToPage + "</page>" + "\n"
                    + "<endLinks>";
        }else return line;
    }

    private String etLinkNextPage_3(String line){
        Pattern p = Pattern.compile("(<p>)(.+)([,]) (.+) (\\d+)[.](<a l:href=\"#n_)(\\d+).*(<\\/p>)");
        Matcher matcher = p.matcher(line);

        return getString(line, matcher);
    }

    private String etLinkNextPage_4(String line){
        Pattern p = Pattern.compile("(<p>)(.+) ([—]) (.+) (\\d+)[.](<a l:href=\"#n_)(\\d+).*(<\\/p>)");
        Matcher matcher = p.matcher(line);

        return getString(line, matcher);
    }

    private String getString(String line, Matcher matcher) {
        if (matcher.find()) {
            String text = matcher.group(2);
            String linkToPage = matcher.group(5);

            return "<startLinks>" + "\n"
                    + "<links>" + text + "</links>" + "<page>" + linkToPage + "</page>" + "\n"
                    + "<endLinks>";
        }else
            return line;
    }

    private String etLinkNextPage_5(String line, String pageNumber){

        Pattern p = Pattern.compile("(<p>)(Смотри следующую страницу[.])(<\\/p>)");
        Matcher matcher = p.matcher(line);

        if (matcher.find()){
            return "<startLinks>" + "\n"+
                    "<links>" + "Сдующая страница" + "</links>"+
                    "<page>" + pageNumber + "</page>" + "\n"
                    + "<endLinks>";
        }
        return line;
    }

    private String etLinkNextPage_6(String line,String pageNumber){

        Pattern p = Pattern.compile("(<p>)(Открой следующую страницу[.])(<\\/p>)");
        Matcher matcher = p.matcher(line);

        if (matcher.find()){
            return "<startLinks>" + "\n"+
                    "<links>" + "Сдующая страница" + "</links>"+
                    "<page>" + pageNumber + "</page>" + "\n"
                    + "<endLinks>";
        }
        return line;
    }


    private String backToPoint(String line){

        Pattern p = Pattern.compile("(<p>)(Возврат)(<a l:href=\"#n_)(\\d+).*(<\\/p>)");
        Matcher matcher = p.matcher(line);

        if (matcher.find()){
            return "<startLinks>" + "\n"+
                    "<links>" + "Возврат" + "</links>"+
                    "<page>" + matcher.group(4) + "</page>" + "\n"
                    + "<endLinks>";
        }
        return line;
    }

    private String theEnd(String line,String pageNumber){

        Pattern p = Pattern.compile("(<text-author>)(КОНЕЦ)(<\\/text-author>)");
        Matcher matcher = p.matcher(line);

        if (matcher.find()){
            return "<startLinks>" + "\n"+
                    "<links>" + "КОНЕЦ" + "</links>"+
                    "<page>" + pageNumber + "</page>" + "\n"
                    + "<endLinks>";
        }
        return line;
    }
}
