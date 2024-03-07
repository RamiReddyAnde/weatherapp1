package net.javaguides.weatherapp.service.impl;

import net.javaguides.weatherapp.entity.Weather;
import net.javaguides.weatherapp.repository.WeatherRepository;
import net.javaguides.weatherapp.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl  implements WeatherService {

    private WeatherRepository weatherrepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository)
    {
        this.weatherrepository = weatherRepository;
    }


    @Override
    public Weather addWeatherRecord(Weather weather) {

        Weather savedWeather = weatherrepository.save(weather);
        return savedWeather;
    }

    @Override
    public Optional<Weather> getWeatherRecord(Integer id) {
        return weatherrepository.findById(id);
    }

    @Override
    public void deleteWeatherrecord(Integer id) {
        weatherrepository.deleteById(id);


    }

    @Override
    public List<Weather> getAllWeatherRecords() {
      return  weatherrepository.findAll();
    }
}
