package Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PoemModel {

    public String getPoemString(String url) {
        Document doc;
        String poem;
        try {
            doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByTag("blockquote");
            poem = elements.toString();
            return poem;
        } catch (IOException e) {
            e.printStackTrace();
            return "Cannot find the poem";
        }
    }
    public void parsePoem(String poem){
        List<String> words = new ArrayList<>(Arrays.asList(poem.split("[.|,|\\s+]")));
        removeUnnecessaryWords(words);
        for (String word:words) {
            //System.out.println("["+word+"]");
        }
        HashMap<String, Integer> str = new HashMap<>();
        int i=0;
        for (String word : words) {
            if (!str.containsKey(word)) {
                System.out.println(i++ + " - " + word);
                str.put(word, 0);
            }
            str.put(word, str.get(word) + 1);

        }
        System.out.println("===========================/");
        i=0;
        for (String word : str.keySet()) {
            System.out.println(i++ +"{"+word+"}" + "==" + str.get(word));
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

    }

    public List<String> removeUnnecessaryWords(List<String> words){
        int blankCounter = 0;
        for (String word:words) {
            if(word.equals("")||word.equals("<br>")||word.equals("</blockquote>")||word.equals("<blockquote>")){
                blankCounter++;
            }
        }
        for (int i=0;i<blankCounter;i++ ){
            if (words.contains("")) words.remove("");
            if (words.contains("<br>")) words.remove("<br>");
            if (words.contains("<blockquote>")) words.remove("<blockquote>");
            if (words.contains("</blockquote>")) words.remove("</blockquote>");
        }
        return words;
    }
    public static void main(String[] args) {

    }
}
