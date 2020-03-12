package com.weather.WeatherModel;

public class User implements Observer{
    String name;
    String city;

    WeatherData weatherData;


    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public void update(WeatherData weatherData) {
        this.weatherData = weatherData;
        System.out.println(getName()+": temperature in "+ getCity()+ ", it's " +  weatherData.getTemperature() + " degrees `C | Humidity - " + weatherData.getHumidity() +"% | Last update - " + weatherData.getLastUpdate());
    }
}
