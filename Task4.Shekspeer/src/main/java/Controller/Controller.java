package Controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(poemModel.urls.size());
        for (int i=0;i<poemModel.urls.size();i++){
            System.out.println(poemModel.urls.get(i));
            Map<String,Integer> mapWordsOnePage = poemModel.parsePoem(poemModel.getPoemString(poemModel.urls.get(i)));
            view.show(mapWordsOnePage);
        }

        //System.out.println(poemModel.urls.get(0));
//        String poem1 = poemModel.getPoemString("http://shakespeare.mit.edu/Poetry/sonnet.I.html");
//        poemModel.parsePoem(poem1);
//        String poem2 = poemModel.getPoemString("http://shakespeare.mit.edu/Poetry/sonnet.II.html");
//        poemModel.parsePoem(poem2);
    }

    public static void main(String[] args) {

    }
}
