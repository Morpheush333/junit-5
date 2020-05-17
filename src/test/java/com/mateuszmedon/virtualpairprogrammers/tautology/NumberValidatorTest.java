package com.mateuszmedon.virtualpairprogrammers.tautology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    NumberValidator validator;

    @BeforeEach
    void setUp(){
        this.validator = new NumberValidator();
    }

    @Test
    public void should_ReturnTrue_When_NumberIsPrime() {

        Integer[] numbers = {23,61,79};

        for (Integer number : numbers) {
            assertTrue(validator.isItPrime(number));
        }
    }

    @ParameterizedTest(name = "number = {0}")
    @CsvSource(value = {"1","22", "63", "81", "25", "207"})
    public void should_ReturnFalse_When_NumberIsNotPrime(Integer number) {
        assertFalse(validator.isItPrime(number));
    }



}