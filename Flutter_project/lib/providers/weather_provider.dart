import 'dart:convert';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class WeatherProvider extends ChangeNotifier {
  String apiKey = "474516e9f1b0518678e8b7806b45c5de";
  Map<String, dynamic> _weatherData = {};
  List<dynamic> _forecastData = []; // Store forecast data
  bool _isLoading = false;

  Map<String, dynamic> get weatherData => _weatherData;
  List<dynamic> get forecastData => _forecastData;
  bool get isLoading => _isLoading;

  Future<void> fetchWeather(String city) async {
    _isLoading = true;
    notifyListeners();

    final weatherUrl =
        "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey&units=metric";
    final forecastUrl =
        "https://api.openweathermap.org/data/2.5/forecast?q=$city&appid=$apiKey&units=metric";

    try {
      final weatherResponse = await http.get(Uri.parse(weatherUrl));
      final forecastResponse = await http.get(Uri.parse(forecastUrl));

      if (weatherResponse.statusCode == 200 && forecastResponse.statusCode == 200) {
        _weatherData = json.decode(weatherResponse.body);
        _forecastData = json.decode(forecastResponse.body)['list'];

        // Store in Firebase
        FirebaseFirestore.instance.collection('weather_history').add({
          'city': _weatherData['name'],
          'temperature': _weatherData['main']['temp'],
          'weather': _weatherData['weather'][0]['description'],
          'timestamp': Timestamp.now(),
        });
      } else {
        _weatherData = {};
        _forecastData = [];
      }
    } catch (error) {
      _weatherData = {};
      _forecastData = [];
    }

    _isLoading = false;
    notifyListeners();
  }
}
