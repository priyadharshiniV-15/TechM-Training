import 'package:flutter/material.dart';

IconData getWeatherIcon(String weatherCondition) {
  switch (weatherCondition.toLowerCase()) {
    case 'clear':
      return Icons.wb_sunny;
    case 'clouds':
      return Icons.cloud;
    case 'rain':
      return Icons.umbrella;
    case 'thunderstorm':
      return Icons.flash_on;
    case 'snow':
      return Icons.ac_unit;
    case 'mist':
    case 'fog':
      return Icons.blur_on;
    case 'drizzle':
      return Icons.grain;
    default:
      return Icons.help_outline; // Default "?" icon
  }
}
