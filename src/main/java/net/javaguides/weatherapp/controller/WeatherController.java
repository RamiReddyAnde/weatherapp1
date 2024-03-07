package net.javaguides.weatherapp.controller;

import net.javaguides.weatherapp.entity.Weather;
import net.javaguides.weatherapp.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService)
    {
        this.weatherService = weatherService;
    }

    @PostMapping("/weather")
    public ResponseEntity<Weather> addWeatherRecord(@RequestBody Weather weather)
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(weather);
    }
    @GetMapping("/weather")
    public List<Weather> getWeatherRecords()
    {
        return weatherService.getAllWeatherRecords();
//        return ResponseEntity.ok(weatherService.getAllWeatherRecords());
    }

    @GetMapping("/weather/{id}")
    public ResponseEntity<Optional<Weather>> getWeatherRecordById(@PathVariable Integer id)
    {
         Optional<Weather> weather = weatherService.getWeatherRecord(id);

         if(weather.isPresent()){

             return ResponseEntity.ok(weather);
         }
         else{
             return ResponseEntity
                     .notFound()
                     .build();
         }

    }

    @DeleteMapping("/weather/{id}")
    public ResponseEntity<Void> deleteWeatherRecord(@PathVariable Integer id)
    {
        //Check if record is existing
        // then delete and send 204 code
        //if doesn't exist, then send the 404 code
        Optional<Weather> weather = weatherService.getWeatherRecord(id);

        if(weather.isPresent()) {
            weatherService.deleteWeatherrecord(id);
            // Return 204 (No Content) if record exists and is deleted successfully
            return ResponseEntity.noContent().build();
        }
        else
        {
            // Return 404 (Not Found) if record does not exist
            return ResponseEntity.notFound().build();
        }
    }
}
