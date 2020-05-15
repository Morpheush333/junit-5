package com.mateuszmedon.isbntools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StockManagerTest {

    @Test
    void should_ReturnCorrectLocatorCode_When_IsCall(){

        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookUp(String isbn) {
                return new Book(isbn, "The Witcher: Blood of Elves", "Andrzej Sapkowski");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setService(testService);

        String isbn = "1473231078";
        String locatorCode = stockManager.getLocatorCode(isbn);

        assertEquals("1078A5", locatorCode);
    }
}