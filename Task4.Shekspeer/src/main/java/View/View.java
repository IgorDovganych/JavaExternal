package View;

import java.util.Map;

public class View {
    public void show(Map<String, Integer> mapWordsOnePage) {
        for (String word : mapWordsOnePage.keySet()) {
            System.out.println(word + " - " + mapWordsOnePage.get(word));
        }
    }
}
