package org.dashuk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static sun.net.www.protocol.http.HttpURLConnection.userAgent;

public class ParseHtml {

    public static ArrayList<String> getText(String url) {
        try {
            Document document = Jsoup.connect(url).userAgent(userAgent).ignoreHttpErrors(true).get();
            String text = document.text();

            return new ArrayList<String>(Arrays.asList(text.split("[, .!?;:\\[\\]\\n()]+")));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ArrayList<String>();
    }

    public static Map<String, Integer> countWords(ArrayList<String> words) {
        Map<String, Integer> quantityWords = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            if (quantityWords.containsKey(currentWord)) {
                quantityWords.put(currentWord, quantityWords.get(currentWord) + 1);
            } else {
                quantityWords.put(currentWord, 1);
            }
        }
        return quantityWords;
    }

    public static void printToConsole(Map<String, Integer> printMap) {
        for (Map.Entry<String, Integer> eachWord : printMap.entrySet()) {
            System.out.println(eachWord.getKey() + " - " + eachWord.getValue());
        }
    }
}
