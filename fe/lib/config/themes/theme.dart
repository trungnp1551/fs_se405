import 'package:fs_fe/config/utils/export_file.dart';
import 'package:flutter/material.dart';

class AppTheme{
  //dark theme
  static ThemeData get light{
    return ThemeData(
      scaffoldBackgroundColor: primaryColor,
      primaryColor: Colors.white, //TextColor
      fontFamily: 'Poppins',
    );
  }

  //light theme
  static ThemeData get dark{
    return ThemeData(
      
    );
  }
}