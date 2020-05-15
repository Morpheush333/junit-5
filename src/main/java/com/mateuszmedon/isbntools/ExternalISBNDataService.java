package com.mateuszmedon.isbntools;

public interface ExternalISBNDataService {
    Book lookUp(String isbn);
}
