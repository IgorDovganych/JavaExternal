package com.weather.WeatherModel;


//Подписчик приложения Погода
public interface Observer {
    void update(WeatherData weatherData);
    String getName();
    String getCity();
}


//Приложение погода
interface Subject {
    void registerObserver(Observer observer);
    void notifyObservers();
}