package com.weather.WeatherModel;


//Подписчик приложения Погода
public interface Observer {
    void update(float temperature);
    String getName();
    String getCity();
}


//Приложение погода
interface Subject {
    void registerObserver(Observer observer);
    void notifyObservers(float temperature);
}