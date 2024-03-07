package net.javaguides.weatherapp.service;

import net.javaguides.weatherapp.entity.Weather;

import java.util.List;
import java.util.Optional;

public interface WeatherService {

    Weather addWeatherRecord(Weather weather);

    Optional<Weather> getWeatherRecord(Integer id);

    void deleteWeatherrecord(Integer id);

    List<Weather> getAllWeatherRecords();

}
