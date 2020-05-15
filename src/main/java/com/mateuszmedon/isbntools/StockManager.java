package com.mateuszmedon.isbntools;

public class StockManager {

    ExternalISBNDataService service;

    public void setService(ExternalISBNDataService service) {
        this.service = service;
    }

    public String getLocatorCode(String isbn) {
        Book book = service.lookUp(isbn);
        StringBuilder sb = new StringBuilder();
        sb.append(isbn.substring(isbn.length()-4));
        sb.append(book.getAuthor().substring(0,1));
        sb.append(book.getTitle().split(" ").length);
        return sb.toString();
    }
}
