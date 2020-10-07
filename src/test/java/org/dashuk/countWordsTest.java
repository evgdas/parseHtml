package org.dashuk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.dashuk.ParseHtml.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.dashuk.ParseHtml.*;

public class countWordsTest {
    final String URL = "https://yandex.ru/";

    @Test
    public void parseTexttoArray() {
        ArrayList<String> words = ParseHtml.getText(URL);
        String firstWord = words.get(0);

        assertNotNull(words);
        assertEquals(firstWord, "Яндекс");
    }

    @Test
    public void checkNumbers() {
        ArrayList<String> words = ParseHtml.getText(URL);
        int count = ParseHtml.countWords(words).get("почтуВойти");

        assertEquals(count, 1);
    }

    @Test
    public void printConsole() {
        printToConsole(countWords(getText(URL)));
    }
}
