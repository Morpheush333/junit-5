package com.mateuszmedon.isbntools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class StockManagerTest {

    ExternalISBNDataService databaseService;
    ExternalISBNDataService webService;

    StockManager stockManager;

    @BeforeEach
    void setUp() {
        this.stockManager = new StockManager();
        this.databaseService = mock(ExternalISBNDataService.class);
        this.webService = mock(ExternalISBNDataService.class);
        stockManager.setWebService(databaseService);
        stockManager.setDatabaseService(webService);
    }


    @Test
    void should_ReturnCorrectLocatorCode_When_DataExistInWebService() {

        when(webService.lookUp("1473231078")).thenReturn(new Book("1473231078", "The Witcher: Blood of Elves", "Andrzej Sapkowski"));
        when(databaseService.lookUp("1473231078")).thenReturn(null);

        String isbn = "1473231078";
        String locatorCode = stockManager.getLocatorCode(isbn);

        assertEquals("1078A5", locatorCode);
    }

    @Test
    void should_ReturnCorrectLocatorCodeFromDatabase_When_DataIsPresent() {

        when(databaseService.lookUp("1473231078")).thenReturn(new Book("1473231078", "abc", "abc"));

        String isbn = "1473231078";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(databaseService).lookUp("1473231078");
        verify(webService, never()).lookUp(anyString());
    }

    @Test
    void should_ReturnCorrectLocatorCodeFromWebService_When_DataIsPresent() {

        when(databaseService.lookUp("1473231078")).thenReturn(null);
        when(webService.lookUp("1473231078")).thenReturn(new Book("1473231078", "abc", "abc"));

        String isbn = "1473231078";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(databaseService).lookUp("1473231078");
        verify(webService).lookUp("1473231078");
    }


}