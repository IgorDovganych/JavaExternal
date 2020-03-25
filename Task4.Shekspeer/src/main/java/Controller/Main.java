package Controller;

import Model.PoemModel;
import View.View;

public class Main {
    public static void main(String[] args) {
        PoemModel poemModel = new PoemModel();
        View view = new View();
        Controller controller = new Controller(poemModel,view);
        controller.start();
    }
}
