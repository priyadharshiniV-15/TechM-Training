import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:weather_app/providers/weather_provider.dart';
import 'package:weather_app/screens/details_screen.dart';
import 'package:weather_app/providers/theme_provider.dart';
import 'package:weather_app/widgets/weather_icon.dart'; // Ensure this is correct

class HomeScreen extends StatelessWidget {
  final TextEditingController _cityController = TextEditingController();

  HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final weatherProvider = Provider.of<WeatherProvider>(context);
    final themeProvider = Provider.of<ThemeProvider>(context);

    return Scaffold(
      backgroundColor:
          themeProvider.isDarkMode ? const Color.fromARGB(255, 0, 0, 0) : Colors.white,
      appBar: AppBar(
        title: Text(
          '🌤️ Weather App',
          style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
        ),
        centerTitle: true,
        backgroundColor:
            themeProvider.isDarkMode ? const Color.fromARGB(255, 225, 225, 225) : Colors.blue,
        actions: [
          IconButton(
            icon: Icon(
              themeProvider.isDarkMode ? Icons.light_mode : Icons.dark_mode,
              color: Colors.white,
            ),
            onPressed: () {
              themeProvider.toggleTheme();
            },
          ),
        ],
      ),
      body: Padding(
        padding: EdgeInsets.all(20.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            // Search Bar
            TextField(
              controller: _cityController,
              style: TextStyle(
                color: themeProvider.isDarkMode ? Colors.white : Colors.black,
              ),
              decoration: InputDecoration(
                filled: true,
                fillColor:
                    themeProvider.isDarkMode
                        ? Colors.blueGrey[700]
                        : Colors.blue[100],
                hintText: "Enter City",
                hintStyle: TextStyle(
                  color:
                      themeProvider.isDarkMode
                          ? const Color.fromARGB(255, 255, 255, 255)
                          : Colors.black54,
                ),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                  borderSide: BorderSide.none,
                ),
                prefixIcon: Icon(
                  Icons.search,
                  color: themeProvider.isDarkMode ? Colors.white : Colors.black,
                ),
              ),
            ),
            SizedBox(height: 20),

            ElevatedButton(
              onPressed: () {
                weatherProvider.fetchWeather(_cityController.text);
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 101, 214, 224),
                padding: EdgeInsets.symmetric(horizontal: 40, vertical: 12),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
              child: Text('Get Weather', style: TextStyle(fontSize: 18)),
            ),

            SizedBox(height: 20),

            // Loading Indicator
            if (weatherProvider.isLoading)
              Center(
                child: CircularProgressIndicator(color: const Color.fromARGB(255, 93, 212, 216)),
              ),

            // Weather Info
            if (weatherProvider.weatherData.isNotEmpty)
              Card(
                color:
                    themeProvider.isDarkMode
                        ? Colors.blueGrey[800]
                        : Colors.blue[50],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(15),
                ),
                elevation: 5,
                child: Padding(
                  padding: const EdgeInsets.all(20.0),
                  child: Column(
                    children: [
                      Text(
                        weatherProvider.weatherData['name'] ?? '',
                        style: TextStyle(
                          fontSize: 26,
                          fontWeight: FontWeight.bold,
                          color:
                              themeProvider.isDarkMode
                                  ? Colors.white
                                  : Colors.black,
                        ),
                      ),
                      SizedBox(height: 10),

                      // Weather Icon
                      Icon(
                        getWeatherIcon(
                          weatherProvider.weatherData['weather'][0]['main'],
                        ),
                        size: 50,
                        color: Colors.blue,
                      ),

                      SizedBox(height: 10),
                      Text(
                        "🌡️ Temp: ${weatherProvider.weatherData['main']['temp']}°C",
                        style: TextStyle(
                          fontSize: 22,
                          color:
                              themeProvider.isDarkMode
                                  ? Colors.white70
                                  : Colors.black87,
                        ),
                      ),
                      Text(
                        "🌦️ Weather: ${weatherProvider.weatherData['weather'][0]['description']}",
                        style: TextStyle(
                          fontSize: 18,
                          color:
                              themeProvider.isDarkMode
                                  ? const Color.fromARGB(255, 255, 255, 255)
                                  : Colors.black54,
                        ),
                      ),
                      SizedBox(height: 15),

                      // 🔹 More Details Button with Forecast Data
                      ElevatedButton(
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder:
                                  (context) => DetailsScreen(
                                    weatherProvider.weatherData,
                                    weatherProvider
                                        .forecastData, // Pass forecast data
                                  ),
                            ),
                          );
                        },
                        style: ElevatedButton.styleFrom(
                          backgroundColor: const Color.fromARGB(255, 77, 176, 212),
                          padding: EdgeInsets.symmetric(
                            horizontal: 30,
                            vertical: 10,
                          ),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                        ),
                        child: Text(
                          'More Details',
                          style: TextStyle(fontSize: 18),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
          ],
        ),
      ),
    );
  }
}
