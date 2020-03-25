package Controller;

import Model.PoemModel;
import View.View;

public class Controller {
    PoemModel poemModel;
    View view;

    public Controller(PoemModel poemModel, View view){
        this.poemModel=poemModel;
        this.view=view;
    }

     public void start(){
         System.out.println("Poem controller started");
    }
}
