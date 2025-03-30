import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

class DetailsScreen extends StatefulWidget {
  final Map<String, dynamic> weatherData;
  final List<dynamic> forecastData;

  const DetailsScreen(this.weatherData, this.forecastData, {super.key});

  @override
  _DetailsScreenState createState() => _DetailsScreenState();
}

class _DetailsScreenState extends State<DetailsScreen> with SingleTickerProviderStateMixin {
  int currentDayIndex = 0;
  final ScrollController _scrollController = ScrollController();
  late AnimationController _animationController;

  @override
  void initState() {
    super.initState();
    _animationController = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 300),
    );
  }

  // Group forecast data by day
  Map<String, List<dynamic>> groupForecastByDay() {
    Map<String, List<dynamic>> groupedForecast = {};
    for (var item in widget.forecastData) {
      String date = item['dt_txt'].split(' ')[0]; // Extract YYYY-MM-DD
      groupedForecast.putIfAbsent(date, () => []).add(item);
    }
    return groupedForecast;
  }

  // Change day animation
  void changeDay(int direction) {
    setState(() {
      currentDayIndex += direction;
      if (currentDayIndex < 0) currentDayIndex = 0;
      if (currentDayIndex >= widget.forecastData.length ~/ 8) {
        currentDayIndex = (widget.forecastData.length ~/ 8) - 1;
      }
    });
    _animationController.reset();
    _animationController.forward();
  }

  // Build Google Map widget
  Widget _buildMap() {
    return SizedBox(
      height: 200,
      child: GoogleMap(
        initialCameraPosition: CameraPosition(
          target: LatLng(
            widget.weatherData['coord']['lat'],
            widget.weatherData['coord']['lon'],
          ),
          zoom: 12,
        ),
        markers: {
          Marker(
            markerId: const MarkerId("cityLocation"),
            position: LatLng(
              widget.weatherData['coord']['lat'],
              widget.weatherData['coord']['lon'],
            ),
            infoWindow: InfoWindow(title: widget.weatherData['name']),
          )
        },
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final groupedForecast = groupForecastByDay();
    final dates = groupedForecast.keys.toList();
    final selectedDate = dates[currentDayIndex];
    final dayForecasts = groupedForecast[selectedDate]!;

    return Scaffold(
      appBar: AppBar(
        title: Text("${widget.weatherData['name']} Weather"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const SizedBox(height: 10),

            // Weather Details Card
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(15),
                boxShadow: [BoxShadow(color: Colors.black26, blurRadius: 5)],
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  const Text(
                    '🌦️ Weather Details',
                    style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.blueAccent),
                  ),
                  const Divider(thickness: 1.2, color: Colors.grey),
                  const SizedBox(height: 8),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      Text('🌡️ Temp: ${widget.weatherData['main']['temp']}°C', style: const TextStyle(fontSize: 16)),
                      Text('💧 Humidity: ${widget.weatherData['main']['humidity']}%', style: const TextStyle(fontSize: 16)),
                      Text('🌬️ Wind: ${widget.weatherData['wind']['speed']} m/s', style: const TextStyle(fontSize: 16)),
                    ],
                  ),
                ],
              ),
            ),

            const SizedBox(height: 20),

            // Google Map Section
            const Text(
              "📍 City Location",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.blueAccent),
            ),
            const SizedBox(height: 10),
            _buildMap(), // Google Map Widget

            const SizedBox(height: 20),

            // Forecast Heading
            Center(
              child: Text(
                "$selectedDate - 5-Day Forecast",
                style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.blueAccent),
              ),
            ),

            const SizedBox(height: 10),

            // Forecast Navigation
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                IconButton(
                  icon: Icon(
                    Icons.arrow_back_ios_rounded,
                    size: 28,
                    color: currentDayIndex > 0 ? Colors.blueAccent : Colors.grey,
                  ),
                  onPressed: currentDayIndex > 0 ? () => changeDay(-1) : null,
                  splashRadius: 24,
                ),
                Expanded(
                  child: SizedBox(
                    height: 150,
                    child: AnimatedSwitcher(
                      duration: const Duration(milliseconds: 400),
                      child: ListView.builder(
                        key: ValueKey<int>(currentDayIndex),
                        controller: _scrollController,
                        scrollDirection: Axis.horizontal,
                        itemCount: dayForecasts.length,
                        itemBuilder: (context, index) {
                          var forecast = dayForecasts[index];

                          return Container(
                            key: ValueKey<String>(forecast['dt_txt']),
                            margin: const EdgeInsets.symmetric(horizontal: 8),
                            padding: const EdgeInsets.all(12),
                            decoration: BoxDecoration(
                              gradient: LinearGradient(
                                colors: [Colors.blue.shade300, Colors.blue.shade700],
                                begin: Alignment.topLeft,
                                end: Alignment.bottomRight,
                              ),
                              borderRadius: BorderRadius.circular(12),
                              boxShadow: [
                                BoxShadow(
                                  color: Colors.black.withOpacity(0.2),
                                  blurRadius: 6,
                                  spreadRadius: 2,
                                  offset: const Offset(2, 2),
                                )
                              ],
                            ),
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                Text(
                                  forecast['dt_txt'].split(' ')[1], // Time
                                  style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.white),
                                ),
                                const SizedBox(height: 6),
                                Icon(
                                  _getWeatherIcon(forecast['weather'][0]['main']),
                                  color: Colors.white,
                                  size: 30,
                                ),
                                const SizedBox(height: 6),
                                Text(
                                  "🌡️ ${forecast['main']['temp']}°C",
                                  style: const TextStyle(fontSize: 16, color: Colors.white),
                                ),
                                Text(
                                  "💨 Wind: ${forecast['wind']['speed']} m/s",
                                  style: const TextStyle(fontSize: 14, color: Colors.white),
                                ),
                              ],
                            ),
                          );
                        },
                      ),
                    ),
                  ),
                ),
                IconButton(
                  icon: Icon(
                    Icons.arrow_forward_ios_rounded,
                    size: 28,
                    color: currentDayIndex < dates.length - 1 ? Colors.blueAccent : Colors.grey,
                  ),
                  onPressed: currentDayIndex < dates.length - 1 ? () => changeDay(1) : null,
                  splashRadius: 24,
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  // Get weather icon
  IconData _getWeatherIcon(String condition) {
    switch (condition.toLowerCase()) {
      case 'clear': return Icons.wb_sunny;
      case 'clouds': return Icons.cloud;
      case 'rain': return Icons.umbrella;
      case 'snow': return Icons.ac_unit;
      default: return Icons.cloud_queue;
    }
  }
}
