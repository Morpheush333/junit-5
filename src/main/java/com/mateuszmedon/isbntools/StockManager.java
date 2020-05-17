package com.mateuszmedon.isbntools;

public class StockManager {

    ExternalISBNDataService databaseService;
    ExternalISBNDataService webService;

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }

    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookUp(isbn);
        if (book == null) book = webService.lookUp(isbn);
        StringBuilder sb = new StringBuilder();
        sb.append(isbn.substring(isbn.length()-4));
        sb.append(book.getAuthor().substring(0,1));
        sb.append(book.getTitle().split(" ").length);
        return sb.toString();
    }
}
