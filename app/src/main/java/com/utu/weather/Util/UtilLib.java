package com.utu.weather.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilLib {




  /* K2C transform degree kelvins to centigrade degree
   * @ param tk degree kelvins
   * return centigrade degree
   */

  public static double K2C(double tk) {
    return tk - 273.5;
  }


  /* Unix2Date  transform Unix timestamp to Date format
   * @ param timestamp Unix timestamp
   * return Date format "E, dd MMM"
   */

  public static String Unix2Date(long timestamp) {
    DateFormat dateFormat = new SimpleDateFormat("E, dd MMM");
    Date date = new Date(timestamp * 1000);
    return dateFormat.format(date);
  }

  /* getIconUrlById function is used to build the full URL by the icon id
   * please refer to https://openweathermap.org/weather-conditions#How-to-get-icon-URL
   * @ param iconId this is the icon id
   * return centigrade degree
   */

  public static String getIconUrlById(String iconId) {
    return "http://openweathermap.org/img/wn/" + iconId + "@2x.png";
  }
}
