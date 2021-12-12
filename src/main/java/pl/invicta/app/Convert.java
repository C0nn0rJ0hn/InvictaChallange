package pl.invicta.app;

import java.util.Map;
import java.util.TreeMap;

public class Convert {

    private Map<String, String[]> resultMap;

    public Convert() {
        resultMap = new TreeMap<>();
    }

    public Map<String, String[]> convertToFile(String text) {
        String[] sentences = text.split("[?!.]");
        for(int i = 0; i < sentences.length; i++) {
            String actualText = sentences[i].trim().replaceAll("[^\\w]", " ");
            String[] actualWords = actualText.split("\\s+");
            resultMap.put("Sentence " + (i + 1), actualWords);
        }
        return resultMap;
    }
}
