import 'package:flutter/material.dart';

class ThemeProvider with ChangeNotifier {
  final ThemeMode _themeMode = ThemeMode.light;

  ThemeMode get themeMode => _themeMode;
  bool _isDarkMode = false; 
  bool get isDarkMode => _isDarkMode;
  void toggleTheme() {
    _isDarkMode = !_isDarkMode;
    notifyListeners();
  }
}
