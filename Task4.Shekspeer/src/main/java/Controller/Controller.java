package Controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Model.PoemModel;
import View.View;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Controller {
    private PoemModel poemModel;
    private View view;

    public Controller(PoemModel poemModel, View view) {
        this.poemModel = poemModel;
        this.view = view;
    }

    public void start() {
        String poem1 = poemModel.getPoemString("http://shakespeare.mit.edu/Poetry/sonnet.I.html");
        poemModel.parsePoem(poem1);
        String poem2 = poemModel.getPoemString("http://shakespeare.mit.edu/Poetry/sonnet.II.html");
        poemModel.parsePoem(poem2);
    }

    public static void main(String[] args) {
        String title = "init";
        Document doc;
        try {
            doc = Jsoup.connect("http://shakespeare.mit.edu/Poetry/sonnet.I.html").get();
            title = doc.title();
            Elements elements = doc.getElementsByTag("blockquote");
            System.out.println(elements.size());
//            for (Element element:elements) {
//                System.out.println("1 " + element);
//            }
            String response = elements.toString();
//            System.out.println("string = " + response + "= end of string");
//            int i = 1;
//            for (String parsedWord : response.split(" ")) {
//                System.out.println(i++ + "-" + parsedWord + "*");
//            }

            List<String> words = Arrays.asList(response.split("[.|,|\\s+]"));
            System.out.println("Size = " + words.size());
            //words.remove(1);
            // (",|\\s+");
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
            for (String word : str.keySet()) {
                System.out.println("{"+word+"}" + "==" + str.get(word));
            }
            System.out.println("===========================");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Jsoup Can read HTML page from URL, title : " + title);

    }
}
