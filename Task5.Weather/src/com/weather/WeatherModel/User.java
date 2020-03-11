package com.weather.WeatherModel;

public class User implements Observer{
    String name;
    String city;

    float currentTemperatureInCity;


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
    public void update(float temperature) {
        this.currentTemperatureInCity = temperature;
        System.out.println(getName()+": temperature in "+ getCity()+ " updated it's " + temperature + " degrees ");
    }
}
