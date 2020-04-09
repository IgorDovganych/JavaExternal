package Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class PoemModel {
    public static List<String> urls = new LinkedList<>(Arrays.asList(
            "http://shakespeare.mit.edu/Poetry/sonnet.I.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.II.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.III.html"));

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

    public Map<String, Integer> parsePoem(String poem){
        List<String> words = new ArrayList<>(Arrays.asList(poem.split("[.|,|\\s+]")));
        removeUnnecessaryWords(words);
//        for (String word:words) {
//            //System.out.println("["+word+"]");
//        }
        Map<String, Integer> mapWordsOnePage = new HashMap<>();
        int i=0;
        for (String word : words) {
            if (!mapWordsOnePage.containsKey(word)) {
                //System.out.println(i++ + " - " + word);
                mapWordsOnePage.put(word, 0);
            }
            mapWordsOnePage.put(word, mapWordsOnePage.get(word) + 1);

        }
        i=0;
//        for (String word : mapWordsOnePage.keySet()) {
//            System.out.println(i++ +"{"+word+"}" + "==" + mapWordsOnePage.get(word));
//        }
//        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
//        System.out.println(mapWordsOnePage.keySet());
//        System.out.println(mapWordsOnePage.entrySet());
//
        return mapWordsOnePage;
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

    public Map<String, Map<String, Integer>> getWordsOfAllUrls(){
        Map<String, Map<String, Integer>> wordsOfAllUrls = new HashMap<>();
        //List<String>
        return wordsOfAllUrls;
    }

    public static void main(String[] args) {
        System.out.println(urls.size());
    }

}
