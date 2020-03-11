package com.weather.Controller;

import com.weather.View.View;
import com.weather.WeatherModel.Observer;
import com.weather.WeatherModel.User;
import com.weather.WeatherModel.WeatherModel;

import java.util.regex.Pattern;

public class Controller {
    private WeatherModel weatherModelmodel;
    private View view;

    public Controller(WeatherModel weatherModelmodel, View view){
        this.weatherModelmodel = weatherModelmodel;
        this.view = view;
    }

    public void start(){
        weatherModelmodel.registerObserver(new User("Alex","London"));
        while (true) {
            view.showMenu();
            int choice = Utils.getMenuNumber(1,4);
            switch (choice){
                case 1://notify all observers
                    weatherModelmodel.notifyObservers(25);
                    break;

                case 2: // add observer
                    view.writeObserverName();
                    String name = Utils.readString(Pattern.compile("[a-zA-Z]{3,20}"));
                    view.writeObserverCity();
                    String city = Utils.getCity();
                    weatherModelmodel.registerObserver(new User(name, city));

                    //weatherModelmodel.addObserverWithNameAndCity(name,city);
                    break;


                case 3:// show observers
                    weatherModelmodel.showAllObservers();
                    break;
                case 4: // exit
                    return;
            }




        }
    }


}
