package com.weather.Controller;

import com.weather.View.View;
import com.weather.WeatherModel.User;
import com.weather.WeatherModel.WeatherModel;

public class Main {
    public static void main(String[] args) {

        WeatherModel weatherModel = new WeatherModel("Kyiv", new User("Igor", "Kyiv"));
        View view = new View();
        Controller controller = new Controller(weatherModel, view);
        controller.start();
    }
}
